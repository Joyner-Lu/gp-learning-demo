package com.joyner.gp_learning.netty_related.my_rpc_v2.proxy;

import com.joyner.gp_learning.netty_related.my_rpc_v2.rpc.Dispatch;
import com.joyner.gp_learning.netty_related.my_rpc_v2.rpc.protocol.PacketContent;
import com.joyner.gp_learning.netty_related.my_rpc_v2.rpc.transport.ClientConnectFactory;
import com.joyner.gp_learning.netty_related.my_rpc_v2.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
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
public class MyRpcConsumerProxy {

    private InetSocketAddress address;

    public MyRpcConsumerProxy(InetSocketAddress address) {
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
                    //1.获取服务名，也就是类名，方法名，方法参数，以及方法参数类型
                    String serviceName = cls.getName();
                    String methodName = method.getName();
                    Object[] params = args;
                    Class<?>[] paramTypes = method.getParameterTypes();

                    //判断是否是本地调用

                    Object invoker = Dispatch.getInstance().getInvoker(serviceName);
                    Object res = null;
                    if (invoker != null) {
                        System.out.println("====================本地调用================");
                        Method m = invoker.getClass().getMethod(methodName, paramTypes);
                        res = m.invoke(invoker, args);
                    } else {
                        //2.开始封包，包括封包的header以及body
                        PacketContent packetContent = new PacketContent(serviceName, methodName, params, paramTypes);
                        CompletableFuture<Object> future = ClientConnectFactory.transport(packetContent, address);
                        //4.等待返回
                        res = future.get();
                        System.out.println("client return:" + res + ", src arg:" + args[0]);

                    }

                    return res;
                }
            });
            return (T) result;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }


}
