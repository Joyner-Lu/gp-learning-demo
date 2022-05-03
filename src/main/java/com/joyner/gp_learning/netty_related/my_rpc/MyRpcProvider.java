package com.joyner.gp_learning.netty_related.my_rpc;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.util.concurrent.CountDownLatch;

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
public class MyRpcProvider {

    public void startProvider() {
        try {
            UserService userService = new UserServiceImpl();
            Dispatch.getInstance().register(UserService.class.getName(), userService);

            NioEventLoopGroup group = new NioEventLoopGroup(50);
            ServerBootstrap bs = new ServerBootstrap();
            ChannelFuture bind = bs.group(group)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new ServerDecoderHandler());
                            pipeline.addLast(new ServerRequestHandler());
                        }
                    })
                    .bind(new InetSocketAddress(9090));
            bind.sync().channel().closeFuture().sync();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public static void main(String[] args) {

        MyRpcProvider provider = new MyRpcProvider();
        provider.startProvider();
    }

}
