package com.joyner.gp_learning.rpc.client;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

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
public class MyRpcDemo {

    private static final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args ) throws Exception {
        //只有一个socket 连接的时候，多线程发送会有问题
        //TODO 原因待分析：

        ClientFactory.initClientPool();
        //执行100次
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                Random random = new Random();
                int i1 = random.nextInt(100);
                IRpcDemo rpcDemo = RpcProxy.proxyGet(IRpcDemo.class);
                String name = "joyner" + count.getAndIncrement();
                String s = rpcDemo.sayHello(name);
                if  (!("hello " + name).equals(s)) {
                    throw new RuntimeException("error,result:" + s + ",req:" + name);
                }
            }).start();
        }



    }


}
