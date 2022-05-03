package com.joyner.gp_learning.jvm_related;

import com.joyner.gp_learning.java_basic.type_learning.PrintUtils;

import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * cache line的大小64个字节
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
public class CacheLineDemo1 {
    public static class T {
        public volatile long x = 0l;
    }

    public static T[] arr = new T[2];
    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (long i = 0; i < 1000_0000l; i++) {
                arr[0].x = i;
            }
        });

        Thread t2 = new Thread(()->{
            for (long i = 0; i < 1000_0000l; i++) {
                arr[1].x = i;
            }
        });
        final long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.nanoTime();
        System.out.println((end - start)/100_1000);

        System.out.println(TimeUnit.NANOSECONDS.toMillis((end - start)));
    }

}
