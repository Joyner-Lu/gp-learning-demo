package com.joyner.gp_learning.rpc.server;

import com.joyner.gp_learning.rpc.base.*;
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
public class MyRpcServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf byteBuf = (ByteBuf) msg;
        long bodyLength = byteBuf.getLong(RpcConstant.BODY_LENGTH_INDEX);
        if (byteBuf.readableBytes() >= bodyLength + RpcConstant.HEADER_LEN) {
            //读取header
            int type = byteBuf.readInt();
            long requestId = byteBuf.readLong();

            byteBuf.readLong();

            byte[] bodyBytes = new byte[(int) bodyLength];
            byteBuf.readBytes(bodyBytes);
            RpcReqBody obj = RpcUtil.getObj(RpcReqBody.class, bodyBytes);
            String serviceName = obj.getServiceName();
            String methodName = obj.getMethodName();
            Object[] params = obj.getParams();
            //通过反射进行调用
            Class<?> clazz = ServerRegistry.get(serviceName);
            Object instance = clazz.newInstance();
            Object result = clazz.getMethod(methodName, obj.getParameterTypes()).invoke(instance, params);
            RpcResBody rpcResBody = new RpcResBody(result);
            ByteBuf resultBody = RpcUtil.getByteBuf(rpcResBody);

            System.out.println("server receive msg, requestId:" + requestId + ",serviceName:" + serviceName + ",methodName:" + methodName + ",result:" + result);


            //构造header
            RpcHeader rpcHeader = new RpcHeader(requestId, resultBody.readableBytes());
            ByteBuf response = RpcUtil.buildResponse(rpcHeader, rpcResBody);
            ctx.writeAndFlush(response);
        }


    }
}
