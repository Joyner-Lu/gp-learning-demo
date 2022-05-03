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
@ChannelHandler.Sharable
public class ChannelInit extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        NioSocketChannel socketChannel = (NioSocketChannel)ctx.channel();
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new MyInHandler());
        pipeline.remove(this);
    }
}
