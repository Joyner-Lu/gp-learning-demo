package com.joyner.gp_learning.netty_related.get_started;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

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
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    /*@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        // Discard the received data silently.
        ((ByteBuf) msg).release(); // (3)
    }*/

    //收数据
    /*@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //释放掉数据
        ByteBuf byteBuf = (ByteBuf) msg;
        try {
            while (byteBuf.isReadable()) {
                System.out.println((char) byteBuf.readByte());
                System.out.flush();
            }
        } finally {
            //需要自己释放bytebuf
            ReferenceCountUtil.refCnt(byteBuf);
        }
    }
*/

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.writeAndFlush(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
