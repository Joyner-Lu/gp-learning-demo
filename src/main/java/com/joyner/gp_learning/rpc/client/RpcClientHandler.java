package com.joyner.gp_learning.rpc.client;

import com.joyner.gp_learning.rpc.base.RpcConstant;
import com.joyner.gp_learning.rpc.base.RpcResBody;
import com.joyner.gp_learning.rpc.base.RpcUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

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
public class RpcClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //读取服务端的返回
        ByteBuf byteBuf = (ByteBuf) msg;
        if (byteBuf.readableBytes() >= RpcConstant.HEADER_LEN) {
            //读取header
            long bodyLength = byteBuf.getLong(RpcConstant.BODY_LENGTH_INDEX);

            //读取body
            if (byteBuf.readableBytes() >= bodyLength + RpcConstant.HEADER_LEN) {
                //读取header
                int type = byteBuf.readInt();
                long requestId = byteBuf.readLong();
                byteBuf.readLong();
                byte[] bodyBytes = new byte[(int) bodyLength];
                byteBuf.readBytes(bodyBytes);
                RpcResBody obj = RpcUtil.getObj(RpcResBody.class, bodyBytes);
                CallbackHandler.run(requestId, obj);
                System.out.println("client receive msg, requestId:" + requestId + ",result:" + obj.getResult());
            }
        }


    }
}
