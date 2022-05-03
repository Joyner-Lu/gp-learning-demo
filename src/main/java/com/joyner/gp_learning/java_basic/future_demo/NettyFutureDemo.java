package com.joyner.gp_learning.java_basic.future_demo;


import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;

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
public class NettyFutureDemo {

    public static void main(String[] args) throws Exception {
        long l = System.currentTimeMillis();
        EventExecutorGroup group = new DefaultEventExecutorGroup(4);
        //new PromiseTask<T>(this, callable);
        //Promise<V> extends Future<V>  promise是future的扩展
        Future<Integer> f = group.submit(new NettyCallableTask());
        f.addListener(new NettyFutureListener(f));
        System.out.println("主线程运算耗时:" + (System.currentTimeMillis() - l) + "ms");
        System.out.println("结果：" + f.get());

        group.shutdownGracefully();
    }


}
