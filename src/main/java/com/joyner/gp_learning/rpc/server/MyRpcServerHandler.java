package com.joyner.gp_learning.rpc.server;

import com.joyner.gp_learning.rpc.base.RpcHeader;
import com.joyner.gp_learning.rpc.base.RpcReqBody;
import com.joyner.gp_learning.rpc.base.RpcResBody;
import com.joyner.gp_learning.rpc.base.RpcUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
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
 *
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
public class MyRpcServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RpcReq req = (RpcReq) msg;
        //这是请求的头部
        RpcHeader rpcHeader = req.getRpcHeader();
        RpcReqBody rpcReqBody = req.getRpcReqBody();

        String serviceName = rpcReqBody.getServiceName();
        String methodName = rpcReqBody.getMethodName();
        Object[] params = rpcReqBody.getParams();
        //通过反射进行调用
        Class<?> clazz = ServerRegistry.get(serviceName);
        Object instance = clazz.newInstance();
        Object result = clazz.getMethod(methodName, rpcReqBody.getParameterTypes()).invoke(instance, params);
        RpcResBody rpcResBody = new RpcResBody(result);

        //构造header
        ByteBuf resultBody = RpcUtil.getByteBuf(rpcResBody);
        //构造header
        RpcHeader rpcHeaderRes = new RpcHeader(rpcHeader.getRequestId(), resultBody.readableBytes());


        System.out.println("server receive msg, requestId:" + rpcHeaderRes.getRequestId() + ",serviceName:" + serviceName + ",methodName:" + methodName + ",result:" + result);
        ByteBuf response = RpcUtil.buildResponse(rpcHeaderRes, rpcResBody);
        ctx.writeAndFlush(response);
    }
}
