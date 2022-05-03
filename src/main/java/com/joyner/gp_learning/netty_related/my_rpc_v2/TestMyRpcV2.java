package com.joyner.gp_learning.netty_related.my_rpc_v2;

import com.joyner.gp_learning.netty_related.my_rpc_v2.entity.UserInfo;
import com.joyner.gp_learning.netty_related.my_rpc_v2.proxy.MyRpcConsumerProxy;
import com.joyner.gp_learning.netty_related.my_rpc_v2.service.MyRpcProvider;
import com.joyner.gp_learning.netty_related.my_rpc_v2.service.UserService;
import org.junit.Test;

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
public class TestMyRpcV2 {

    private static AtomicInteger idx = new AtomicInteger(0);

/*
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


    }*/
/*

    private static void consumer(InetSocketAddress address) {
        MyRpcConsumerProxy consumer = new MyRpcConsumerProxy(address);
        UserService userService = consumer.getUserService();
        userService.deleteUser("test" + "_" + idx.getAndIncrement());
    }
*/


    @Test
    public void startPriverder() {
        InetSocketAddress address = new InetSocketAddress(9090);
        MyRpcProvider provider = new MyRpcProvider(address);
        provider.startProvider();
    }

    @Test
    public void startConsumer() throws Exception {
        InetSocketAddress address = new InetSocketAddress(9090);
        MyRpcConsumerProxy myRpcConsumerProxy = new MyRpcConsumerProxy(address);
        UserService userService = myRpcConsumerProxy.getUserService();
        UserInfo test001 = userService.findUser("test001");
        System.out.println(test001);

        userService.updateUser("userid1");
        System.in.read();
    }

    @Test
    public void startAll() {

    }
}
