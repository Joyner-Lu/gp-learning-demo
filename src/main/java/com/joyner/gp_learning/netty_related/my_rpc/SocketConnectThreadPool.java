package com.joyner.gp_learning.netty_related.my_rpc;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.util.Random;

/**
 * <pre>
 * socket连接池
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
public class SocketConnectThreadPool {

    private NioSocketChannel[] clients;
    private Object[] locks;
    private Random random = new Random();

    public SocketConnectThreadPool(int size) {
        clients = new NioSocketChannel[size];
        locks = new Object[size];
        for (int i = 0; i < size; i++) {
            locks[i] = new Object();
        }
    }



    public NioSocketChannel getClient(InetSocketAddress address) {
        int idx = random.nextInt(clients.length);
        NioSocketChannel client = clients[idx];
        //若为空则创建
        if (client == null) {
            synchronized (locks[idx]) {
                if (client == null) {
                    client = create(address);
                    clients[idx] = client;
                }
            }
        }
        return client;
    }

    private NioSocketChannel create(InetSocketAddress address) {
        try {
            NioEventLoopGroup group = new NioEventLoopGroup(1);
            Bootstrap bs = new Bootstrap();
            ChannelFuture connect = bs.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<NioSocketChannel>() {

                        @Override
                        protected void initChannel(NioSocketChannel ch) {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new ServerDecoderHandler());
                            pipeline.addLast(new RpcResponseHandler());
                        }
                    }).connect(address);
            connect.sync();//等待连接成功
            return (NioSocketChannel)connect.channel();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
