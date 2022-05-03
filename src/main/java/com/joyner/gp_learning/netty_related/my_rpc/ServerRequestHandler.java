package com.joyner.gp_learning.netty_related.my_rpc;

import com.joyner.gp_learning.common.utils.ObjectUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.reflect.Method;

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
public class ServerRequestHandler extends ChannelInboundHandlerAdapter {



    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String ioThreadName = Thread.currentThread().getName();

        ctx.executor().parent().next().execute(()->{
            try {
                //解析封包
                PacketMsg packetMsg = (PacketMsg)msg;
                String execThreadName = Thread.currentThread().getName();
                //String res = "server,ioThreadName:" + ioThreadName + ", execThreadName:" + execThreadName + ", param:" + packetMsg.getPacketContent().getParams()[0];
                System.out.println();

                System.out.println(packetMsg.getPacketHeader());
                System.out.println(packetMsg.getPacketBody());




                //获取请求相关参数

                PacketBody requestBody = packetMsg.getPacketBody();
                String serviceName = requestBody.getServiceName();
                String methodName = requestBody.getMethodName();
                Object[] params = requestBody.getParams();
                Class<?>[] paramTypes = requestBody.getParamTypes();
                Object obj = Dispatch.getInstance().getInvoker(serviceName);
                Method method = obj.getClass().getMethod(methodName, paramTypes);
                String res = (String)method.invoke(obj, params);


                PacketBody returnPacketBody = new PacketBody();
                returnPacketBody.setRes(res);
                byte[] packetBodyBytes = ObjectUtils.objToBytes(returnPacketBody);

                PacketHeader packetHeader = packetMsg.getPacketHeader();
                packetHeader.setFlag(0x14141424);
                packetHeader.setDataLen(packetBodyBytes.length);
                byte[] packetHeaderBytes = ObjectUtils.objToBytes(packetHeader);

                ByteBuf buffer = PooledByteBufAllocator.DEFAULT.buffer(packetHeaderBytes.length + packetBodyBytes.length);
                buffer.writeBytes(packetHeaderBytes);
                buffer.writeBytes(packetBodyBytes);
                ctx.channel().writeAndFlush(buffer);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }


        });



    }
}
