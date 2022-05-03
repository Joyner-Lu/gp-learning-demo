package com.joyner.gp_learning.java_basic.future_demo;

import org.junit.Test;
import sun.nio.ch.ThreadPool;

import java.util.concurrent.*;

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
public class FutureTest {


    @Test
    public void test01() throws Exception {
        BlockingQueue queue = new ArrayBlockingQueue(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 10, 1, TimeUnit.MINUTES, queue
                , Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        Future<String> submit = threadPoolExecutor.submit(new CallableTask());
        System.out.println(submit.get());

        threadPoolExecutor.shutdown();
    }

    @Test
    public void test02() throws Exception {
        BlockingQueue queue = new ArrayBlockingQueue(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 10, 1, TimeUnit.MINUTES, queue
                , Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        Future submit = threadPoolExecutor.submit(new RunnableTask());
        System.out.println(submit.get());

        threadPoolExecutor.shutdown();
    }


}
