package com.joyner.gp_learning.netty_related.get_started;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

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
public class TimeServerClient {

    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup selector = new NioEventLoopGroup();
        Bootstrap client = new Bootstrap();
        ChannelFuture connect = client.group(selector)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new TimeDecoder()).addLast(new TimeClientHandler());
                    }
                })
                .connect(new InetSocketAddress(9999));

        connect.sync().channel().closeFuture().sync();


    }
}
