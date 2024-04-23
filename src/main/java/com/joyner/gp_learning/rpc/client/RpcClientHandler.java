package com.joyner.gp_learning.rpc.client;

import com.joyner.gp_learning.rpc.base.RpcRes;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * <pre>
 *  | header1  body1 header2 body2 |   这种读取到的就是比较完整的数据包
 *  | header1  body1 header2 body2_1|   | body2_1 header3 body3 |  这种就是数据包被分开了
 *  | header1  body1 header2 |   | body2 header3 body3 |  这种就是数据包被分开了
 *  | header1_1 | |header1_2 body1 header2 body2| 这种就是头部都不完整
 *
 *
 *  因此在读取的时候，需要判断是否是一个完整的数据包，如果不是，需要把数据包存起来累积到下一个数据包
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
        RpcRes res = (RpcRes) msg;
        CallbackHandler.run(res.getRpcHeader().getRequestId(), res.getRpcResBody());
    }

}
