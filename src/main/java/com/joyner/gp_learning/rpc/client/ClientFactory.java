package com.joyner.gp_learning.rpc.client;

import com.joyner.gp_learning.rpc.base.RpcConstant;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class ClientFactory {
    private ClientFactory() {
    }
    //key: ip:port value:ClientPool,这里的ip:port是服务端的ip:port
    private static ConcurrentHashMap<String, ClientPool> clientPoolMap = new ConcurrentHashMap<>();



    public static void initClientPool() {
        if (!clientPoolMap.isEmpty()) {
            return;
        }
        long start = System.currentTimeMillis();
        synchronized (clientPoolMap) {
            String key = RpcConstant.SERVER_IP + ":" + RpcConstant.SERVER_PORT;
            //同步
            ClientPool clientPool = new ClientPool(RpcConstant.CLIENT_POOL_SIZE);
            clientPoolMap.put(key, clientPool);
            for (int i = 0; i < RpcConstant.CLIENT_POOL_SIZE; i++) {
                clientPool.getNioSocketChannel()[i] = initNioSocketChannel(clientPool, RpcConstant.SERVER_IP, RpcConstant.SERVER_PORT);
            }
        }
        long end = System.currentTimeMillis();
        //打印耗时，单位是秒
        System.out.println("初始化连接池：" + (end - start) / 1000 + "秒");
    }


    public static NioSocketChannel getClient(String ip, int port) {
        NioSocketChannel result = null;
        long start = System.currentTimeMillis();
        String key = ip + ":" + port;
        ClientPool clientPool = clientPoolMap.get(key);
        if (clientPool != null) {
            int size = clientPool.getSize();
            Random random = new Random();
            int i = random.nextInt(size);
            NioSocketChannel nioSocketChannel = clientPool.getNioSocketChannel()[i];
            if (nioSocketChannel == null && nioSocketChannel.isActive()) {
                synchronized (clientPool.getLocks()[i]) {
                    //同步
                    NioSocketChannel initNioSocketChannel = initNioSocketChannel(clientPool, ip, port);
                    clientPool.getNioSocketChannel()[i] = initNioSocketChannel;
                    result = initNioSocketChannel;
                }
            } else {
                result = nioSocketChannel;
            }
        } else {
            synchronized (clientPoolMap) {
                //同步
                clientPool = new ClientPool(RpcConstant.CLIENT_POOL_SIZE);
                clientPoolMap.put(key, clientPool);
                NioSocketChannel initNioSocketChannel = initNioSocketChannel(clientPool, ip, port);
                Random random = new Random();
                int i = random.nextInt(RpcConstant.CLIENT_POOL_SIZE);
                clientPool.getNioSocketChannel()[i] = initNioSocketChannel;
                result = initNioSocketChannel;
            }
        }
        long end = System.currentTimeMillis();
        //打印耗时，单位是秒
        System.out.println("获取连接耗时：" + (end - start) / 1000 + "秒");
        return result;
    }

    private static NioSocketChannel initNioSocketChannel(ClientPool clientPool, String ip, int port) {
        try {
            Bootstrap bootstrap = new Bootstrap();
            NioEventLoopGroup group = new NioEventLoopGroup();
            NioSocketChannel nioSocketChannel = (NioSocketChannel)bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel ch) throws Exception {
                            ch.pipeline().
                                    addLast(new ClientDecoder()).
                                    addLast(new RpcClientHandler());
                        }
                    })
                    .connect(new InetSocketAddress(ip, port))
                    .sync().channel();
            return nioSocketChannel;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(2);
        //test 100 times
        for (int j = 0; j < 100; j++) {
            System.out.println(random.nextInt(2));
        }
    }
}
