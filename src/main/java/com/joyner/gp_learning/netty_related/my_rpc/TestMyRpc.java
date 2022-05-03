package com.joyner.gp_learning.netty_related.my_rpc;

import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicInteger;

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
public class TestMyRpc {

    private static AtomicInteger idx = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {
        int size = 20;
        final InetSocketAddress address = new InetSocketAddress(9090);
        Thread[] threads = new Thread[size];
        //先运行MyRpcProvider的main方法
        for (int i = 0; i < size; i++) {
            threads[i] = new Thread(()->{consumer(address);});
        }

        for (Thread thread : threads) {
            thread.start();
        }


    }

    private static void consumer(InetSocketAddress address) {
        MyRpcConsumer consumer = new MyRpcConsumer(address);
        UserService userService = consumer.getUserService();
        userService.deleteUser("test" + "_" + idx.getAndIncrement());
    }
}
