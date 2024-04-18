package com.joyner.gp_learning.rpc.server;

import com.joyner.gp_learning.rpc.base.*;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
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

    private byte[] remainBytes;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("server accept client:" + channel.remoteAddress());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        if (remainBytes != null && remainBytes.length > 0) {
            //上次读取剩余的数据包,拼接到byteBuf
            ByteBuf newByteBuf = ByteBufAllocator.DEFAULT.buffer(remainBytes.length + byteBuf.readableBytes());
            newByteBuf.writeBytes(remainBytes);
            newByteBuf.writeBytes(byteBuf);
            remainBytes = null;
            byteBuf.clear();//记得要清理
            byteBuf = newByteBuf;
        }
        while (byteBuf.readableBytes() >= RpcConstant.HEADER_LEN) {
            boolean result = doRes(ctx, byteBuf);
            if (!result) {
                break;
            }
        }

        //处理剩余的数据包
        if (byteBuf.readableBytes() > 0) {
            System.out.println("remain bytes, length:" + byteBuf.readableBytes() + " bytes");
            remainBytes = new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(remainBytes);
        }

    }

    private boolean doRes(ChannelHandlerContext ctx, ByteBuf byteBuf) throws Exception {
        byteBuf.markReaderIndex();
        //读取header
        int type = byteBuf.readInt();
        long requestId = byteBuf.readLong();
        long bodyLength = byteBuf.readLong();


        if (byteBuf.readableBytes() < bodyLength) {
            //数据包不完整,恢复头部
            byteBuf.resetReaderIndex();
            return false;
        }
        //处理body
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
        return true;
    }
}
