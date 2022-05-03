package com.joyner.gp_learning.netty_related.my_rpc_v2.rpc.transport;

import com.joyner.gp_learning.netty_related.my_rpc_v2.rpc.protocol.PacketMsg;
import com.joyner.gp_learning.netty_related.my_rpc_v2.rpc.ResponseMappingCallback;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

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
public class ClientResponseHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //解析封包
        PacketMsg packetMsg = (PacketMsg)msg;
        ResponseMappingCallback.runCallBack(packetMsg);
    }
}
