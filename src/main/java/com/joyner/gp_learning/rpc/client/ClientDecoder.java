package com.joyner.gp_learning.rpc.client;

import com.joyner.gp_learning.rpc.base.*;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

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
public class ClientDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {

        ByteBuf byteBuf = (ByteBuf) msg;
        //读取服务端的返回
        while (byteBuf.readableBytes() >= RpcConstant.HEADER_LEN) {
            RpcRes res = processRes(byteBuf);
            if (res == null) {
                break;
            }
            //输出
            out.add(res);
        }

    }

    private RpcRes processRes(ByteBuf byteBuf) {
        //读取header
        byteBuf.markReaderIndex();
        //读取header
        int type = byteBuf.readInt();
        long requestId = byteBuf.readLong();
        long bodyLength = byteBuf.readLong();

        if (byteBuf.readableBytes() < bodyLength) {
            //数据包不完整,恢复头部
            byteBuf.resetReaderIndex();
            return null;
        }
        RpcHeader rpcHeader = new RpcHeader(requestId, bodyLength);
        rpcHeader.setType(type);

        //读取body
        byte[] bodyBytes = new byte[(int) bodyLength];
        byteBuf.readBytes(bodyBytes);
        RpcResBody obj = RpcUtil.getObj(RpcResBody.class, bodyBytes);
        CallbackHandlerMapping.run(requestId, obj);
        System.out.println("client receive msg, requestId:" + requestId + ",result:" + obj.getResult());
        RpcRes rpcRes = new RpcRes();
        rpcRes.setRpcHeader(rpcHeader);
        rpcRes.setRpcResBody(obj);
        return rpcRes;
    }
}
