package com.joyner.gp_learning.rpc.server;

import com.joyner.gp_learning.rpc.base.RpcConstant;
import com.joyner.gp_learning.rpc.base.RpcHeader;
import com.joyner.gp_learning.rpc.base.RpcReqBody;
import com.joyner.gp_learning.rpc.base.RpcUtil;
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
public class RpcServerDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        while (byteBuf.readableBytes() >= RpcConstant.HEADER_LEN) {
            RpcReq req = doRes(ctx, byteBuf);
            if (req == null) {
                break;
            }
            out.add(req);
        }

    }

    private RpcReq doRes(ChannelHandlerContext ctx, ByteBuf byteBuf) throws Exception {
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
        //处理body
        byte[] bodyBytes = new byte[(int) bodyLength];
        byteBuf.readBytes(bodyBytes);
        RpcReqBody obj = RpcUtil.getObj(RpcReqBody.class, bodyBytes);
        RpcReq rpcReq = new RpcReq();

        RpcHeader header = new RpcHeader(requestId, bodyLength);
        header.setType(type);
        rpcReq.setRpcHeader(header);
        rpcReq.setRpcReqBody(obj);
        return rpcReq;
    }
}
