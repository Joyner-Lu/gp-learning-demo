package com.joyner.gp_learning.rpc.base;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledDirectByteBuf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

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
public class RpcUtil {

    /**
     * 对象转ByteBuf
     *
     * @param obj
     * @return
     */
    public static ByteBuf getByteBuf(Object obj) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer(bytes.length);
            byteBuf.writeBytes(bytes);
            return byteBuf;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static <T> T getObj(Class<T> clazz, byte[] bytes) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            T obj = (T) objectInputStream.readObject();
            return obj;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    /**
     * 生产requestId
     *
     * @return
     */
    public static long getRequestId() {
        //使用随机数生产requestId
        Random random = new Random();
        return Math.abs(random.nextLong());
    }

    public static ByteBuf buildRequest(RpcHeader rpcHeader, RpcReqBody rpcReqBody) {
        ByteBuf bodyByteBuf = getByteBuf(rpcReqBody);
        ByteBuf request = ByteBufAllocator.DEFAULT.buffer(RpcConstant.HEADER_LEN + bodyByteBuf.readableBytes());
        request.writeBytes(rpcHeader.getHeaderByteBuf());
        request.writeBytes(bodyByteBuf);
        bodyByteBuf.release();
        return request;
    }

    public static ByteBuf buildResponse(RpcHeader rpcHeader, RpcResBody rpcResBody) {
        ByteBuf bodyByteBuf = getByteBuf(rpcResBody);
        ByteBuf request = ByteBufAllocator.DEFAULT.buffer(RpcConstant.HEADER_LEN + bodyByteBuf.readableBytes());
        request.writeBytes(rpcHeader.getHeaderByteBuf());
        request.writeBytes(bodyByteBuf);
        return request;
    }
}
