package com.joyner.gp_learning.rpc.base;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.Data;

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
@Data
public class RpcHeader {
    //协议类型
    private int type = 0x01010101;
    private long requestId;
    private long bodyLength;

    private ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer(RpcConstant.HEADER_LEN);


    public RpcHeader(long requestId, long bodyLength) {
        this.requestId = requestId;
        this.bodyLength = bodyLength;
        byteBuf.writeInt(type);
        byteBuf.writeLong(requestId);
        byteBuf.writeLong(bodyLength);
    }

    public ByteBuf getHeaderByteBuf() {
        return byteBuf;
    }
}
