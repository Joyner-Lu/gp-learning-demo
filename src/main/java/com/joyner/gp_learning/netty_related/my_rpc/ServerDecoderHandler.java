package com.joyner.gp_learning.netty_related.my_rpc;

import com.joyner.gp_learning.common.utils.ObjectUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.ByteToMessageCodec;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

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
public class ServerDecoderHandler extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List out) {
        //解析封包
        int packetHeaderSize = 138;
        while (buf.readableBytes() >= packetHeaderSize) {
            //解析header122是header长度
            byte[] packetHeaderBytes = new byte[packetHeaderSize];
            buf.getBytes(buf.readerIndex(), packetHeaderBytes);//先不移动指针
            PacketHeader packetHeader = ObjectUtils.bytesToObj(packetHeaderBytes, PacketHeader.class);
            System.out.println("decode:" + packetHeader);

            if (buf.readableBytes() - packetHeaderSize >= packetHeader.getDataLen()) {
                //移动指针
                buf.readBytes(packetHeaderSize);
                //解析packet body
                byte[] packetBodyBytes = new byte[packetHeader.getDataLen()];
                buf.readBytes(packetBodyBytes);
                PacketBody packetBody = ObjectUtils.bytesToObj(packetBodyBytes, PacketBody.class);
                System.out.println("decode:" + packetBody);
                PacketMsg packetMsg = new PacketMsg(packetHeader, packetBody);
                out.add(packetMsg);
            } else {
                //要跳出循环
                break;
            }
        }

    }

}
