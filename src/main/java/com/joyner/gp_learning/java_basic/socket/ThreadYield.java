package com.joyner.gp_learning.java_basic.socket;


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
public class ThreadYield {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println("begin 51");
            System.out.println("end t1");
        });
        t1.start();
        Thread t2 = new Thread(()->{
            System.out.println("begin t2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end t2");

        });
        t2.start();
        t1.join();
        t2.join();
        System.out.println("main end");

    }
}
