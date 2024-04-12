package com.joyner.gp_learning.rpc.client;

import com.joyner.gp_learning.rpc.base.*;
import io.netty.buffer.ByteBuf;

import java.lang.reflect.Proxy;
import java.util.concurrent.CountDownLatch;

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
public class RpcProxy {


    /**
     *  获取rpc代理对象
     * @param iRpcClass
     * @return
     * @param <T>
     */
    public static <T>T proxyGet(Class<T> iRpcClass) {
        ClassLoader classLoader = iRpcClass.getClassLoader();
        Class<?>[] interfaces = new Class[]{iRpcClass};
        return (T)Proxy.newProxyInstance(classLoader, interfaces, (proxy, method, args) -> {

            //1.调用的服务的名称
            String serviceName = iRpcClass.getName();
            //2.方法名称
            String methodName = method.getName();
            if (methodName.equals("toString") || methodName.equals("hashCode") || methodName.equals("equals")) {
                return null;
            }
            Class<?>[] parameterTypes = method.getParameterTypes();
            //构造header和body
            RpcReqBody rpcReqBody = new RpcReqBody(serviceName, methodName, parameterTypes, args);
            ByteBuf byteBuf = RpcUtil.getByteBuf(rpcReqBody);

            long requestId = RpcUtil.getRequestId();
            System.out.println("send requestId:" + requestId);
            RpcHeader rpcHeader = new RpcHeader(requestId, byteBuf.readableBytes());
            ByteBuf request = RpcUtil.buildRequest(rpcHeader, rpcReqBody);

            //发送请求:1.获取连接 2.发送请求 3.发送完毕之后等待 4.RpcClientHandler处理结果
            ClientFactory.getClient(RpcConstant.SERVER_IP, RpcConstant.SERVER_PORT).writeAndFlush(request).sync();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            CallbackHandler.add(requestId, countDownLatch);
            countDownLatch.await();
            RpcResBody response = CallbackHandler.getResponse(requestId);
            return response.getResult();
        });
    }
}
