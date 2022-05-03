package com.joyner.gp_learning.juc.lock;

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
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        demo2();
    }

    public static void demo1() throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Thread(()->{

            System.out.println("t1 begin");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 end");
            countDownLatch.countDown();
        }, "t1").start();

        new Thread(()->{

            System.out.println("t2 begin");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 end");
            countDownLatch.countDown();
        }, "t2").start();

        new Thread(()->{

            System.out.println("t3 begin");
            //
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3 end");
            countDownLatch.countDown();
        }, "t3").start();

        countDownLatch.await();
        System.out.println("main end");
    }

    public static void demo2() throws InterruptedException {


        Thread t1 = new Thread(()->{

            System.out.println("t1 begin");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 end");
        }, "t1");
        t1.start();

        Thread t2 = new Thread(()->{

            System.out.println("t2 begin");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 end");
        }, "t2");
        t2.start();

        Thread t3 = new Thread(()->{

            System.out.println("t3 begin");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3 end");
        }, "t3");
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("main end");

    }

}
