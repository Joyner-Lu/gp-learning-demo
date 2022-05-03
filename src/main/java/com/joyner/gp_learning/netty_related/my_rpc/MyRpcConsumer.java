package com.joyner.gp_learning.netty_related.my_rpc;

import com.joyner.gp_learning.common.utils.ObjectUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

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
public class MyRpcConsumer {

    private InetSocketAddress address;

    public MyRpcConsumer(InetSocketAddress address) {
        this.address = address;
    }

    public UserService getUserService() {
        UserService userService = proxyGet(UserService.class);
        return userService;
    }

    private <T> T proxyGet(Class<T> cls) {
        try {
            ClassLoader classLoader = cls.getClassLoader();
            Class<?>[] intefaces = {cls};
            Object result = Proxy.newProxyInstance(classLoader, intefaces, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    //1.获取服务名，也就是类名，方法名，方法参数，以及方法参数类型
                    String serviceName = cls.getName();
                    String methodName = method.getName();
                    Object[] params = args;
                    Class<?>[] paramTypes = method.getParameterTypes();

                    //2.开始封包，包括封包的header以及body
                    PacketBody packetBody = new PacketBody(serviceName, methodName, params, paramTypes);
                    byte[] bodyBytes = ObjectUtils.objToBytes(packetBody);


                    int flag = 0x14141414;
                    long requestId = Math.abs(UUID.randomUUID().getLeastSignificantBits());
                    PacketHeader packetHeader = new PacketHeader(flag, requestId, bodyBytes.length);
                    byte[] headerBytes = ObjectUtils.objToBytes(packetHeader);

                    CompletableFuture<String> future = new CompletableFuture<>();
                    //添加回调函数
                    ResponseMappingCallback.addCallBack(requestId, future);

                    //3.获取连接，发送请求(涉及到连继池的设计)
                    NioSocketChannel clientChannel = SocketConnectFactory.openConnect(address);

                    //构建封包数据
                    ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.buffer(headerBytes.length + bodyBytes.length);
                    byteBuf.writeBytes(headerBytes);
                    byteBuf.writeBytes(bodyBytes);
                    clientChannel.writeAndFlush(byteBuf);
                    //4.等待返回
                    String res = future.get();
                    System.out.println("client return:" + res + ", src arg:" + args[0]);
                    return res;
                }
            });
            return (T) result;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }


}
