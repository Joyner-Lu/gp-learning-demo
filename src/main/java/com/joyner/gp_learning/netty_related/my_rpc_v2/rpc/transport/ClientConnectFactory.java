package com.joyner.gp_learning.netty_related.my_rpc_v2.rpc.transport;

import com.joyner.gp_learning.netty_related.my_rpc_v2.rpc.protocol.*;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

import static com.joyner.gp_learning.netty_related.my_rpc_v2.config.Configuration.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqingyun@foresee.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class ClientConnectFactory extends Object {

    //使用volatile的原因是，构建对象的过程是分步骤的
    //如果不加，可能会导致拿到的是半成品。
    private volatile static ClientConnectFactory connectFactory;
    private static ContentTransport contentTransport;

    static {
        if (PROTOCOL == PROTOCOL_HTTP) {
            contentTransport = new HTTPContentTransport();
        } else if (PROTOCOL == PROTOCOL_CUSTOM_RPC) {
            contentTransport = new CustomRPCContentTransport();
        }
    }

    private static ConcurrentHashMap<InetSocketAddress, ClientConnectThreadPool> connPoolMap = new ConcurrentHashMap<>();
    private static final int DEFAULT_POOL_SIZE = CLIENT_SOCKET_NUMS;


    private ClientConnectFactory() {
        throw new RuntimeException("不能重复创建实例");

    }

    public static ClientConnectFactory getInstance() {
        if (connectFactory == null) {
            //第2次判空的目的是，如线程A执行到这里，抢不到锁，那边后面也会进入同步的位置，从而创建多实例
            synchronized (ClientConnectFactory.class) {
                if (connectFactory == null) {//第二次判断空
                    connectFactory = new ClientConnectFactory();
                }
            }
        }
        return connectFactory;
    }

    public static synchronized NioSocketChannel openConnect(InetSocketAddress address) {
        ClientConnectThreadPool connectThreadPool = null;
        if ((connectThreadPool = connPoolMap.get(address)) == null) {
            connectThreadPool = new ClientConnectThreadPool(DEFAULT_POOL_SIZE);
            connPoolMap.put(address, connectThreadPool);
        }
        NioSocketChannel conn = connectThreadPool.getClient(address);
        if (conn.isActive()) {
            return conn;
        }
        return null;

    }

    public static CompletableFuture<Object> transport(PacketContent packetContent, InetSocketAddress address){
        CompletableFuture<Object> future = contentTransport.transport(packetContent, address);
        return future;

    }

    /**
     * 防止序列号
     * @return
     */
    public Object readResolve() {
        //防止反序列号
        return connectFactory;
    }

}
