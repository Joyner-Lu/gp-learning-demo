package com.joyner.gp_learning.netty_related.my_rpc_v2.rpc.protocol;

import com.joyner.gp_learning.common.utils.ObjectUtils;
import com.joyner.gp_learning.netty_related.my_rpc_v2.rpc.ResponseMappingCallback;
import com.joyner.gp_learning.netty_related.my_rpc_v2.rpc.transport.ClientConnectFactory;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

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
public class CustomRPCContentTransport implements ContentTransport {
    @Override
    public CompletableFuture<Object> transport(PacketContent packetContent, InetSocketAddress address) {
        byte[] bodyBytes = ObjectUtils.objToBytes(packetContent);


        int flag = 0x14141414;
        long requestId = Math.abs(UUID.randomUUID().getLeastSignificantBits());
        PacketHeader packetHeader = new PacketHeader(flag, requestId, bodyBytes.length);
        byte[] headerBytes = ObjectUtils.objToBytes(packetHeader);

        CompletableFuture<Object> future = new CompletableFuture<>();
        //添加回调函数
        ResponseMappingCallback.addCallBack(requestId, future);

        //3.获取连接，发送请求(涉及到连继池的设计)
        NioSocketChannel clientChannel = ClientConnectFactory.openConnect(address);

        System.out.println("headerBytes.length:" + headerBytes.length);

        //构建封包数据
        ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.buffer(headerBytes.length + bodyBytes.length);
        byteBuf.writeBytes(headerBytes);
        byteBuf.writeBytes(bodyBytes);
        clientChannel.writeAndFlush(byteBuf);
        return future;
    }
}
