package com.joyner.gp_learning.netty_related;

import io.netty.channel.*;
import io.netty.channel.socket.nio.NioSocketChannel;

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
public class MyAcceptHandler extends ChannelInboundHandlerAdapter {

    private final EventLoopGroup selector;
    private final ChannelHandler handler;

    public MyAcceptHandler(EventLoopGroup selector, ChannelHandler handler) {
        this.selector = selector;
        this.handler = handler;
    }
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyAcceptHandler channelRegistered..........");
    }



    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("MyAcceptHandler channelRead.....");
        NioSocketChannel client = (NioSocketChannel)msg;
        ChannelPipeline pipeline = client.pipeline();
        pipeline.addLast(handler);

        selector.register(client);
    }
}
