package com.joyner.gp_learning.juc.thread;

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
public class YieldDemo {

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            Thread.yield();
            System.out.println("1");

        }).start();
        Thread.sleep(1000);
        new Thread(()->{

            System.out.println("2");

        }).start();
    }
}
