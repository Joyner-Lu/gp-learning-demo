package com.joyner.gp_learning.netty_related.get_started;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

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
public class TimeClientHandler extends ChannelInboundHandlerAdapter {
    private ByteBuf buf;
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        buf = ctx.alloc().buffer(4);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        buf.release();
        buf = null;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            //不需要处理拆包的问题
            //使用TimeDecoder处理了。
            long currentTimeMillis = (buf.readUnsignedInt() - 2208988800L)*1000L;
            System.out.println(DateFormatUtils.format(new Date(currentTimeMillis), "yyyy-MM-dd HH:mm:ss"));
            ctx.close();//关闭连接
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
