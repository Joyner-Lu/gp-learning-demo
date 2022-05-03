package com.joyner.gp_learning.juc.lock;

import java.util.concurrent.Semaphore;

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
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        SemaphoreDemo demo = new SemaphoreDemo();
        for (int i = 0; i < 10; i++) {

            demo.new Car(i+1, semaphore).start();
        }
    }


    class Car extends Thread {
        int id;
        Semaphore semaphore;

        Car(int id, Semaphore semaphore) {
            this.id = id;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("第" + id + "begin");
                Thread.sleep(2000);
                System.out.println("第" + id + "end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }

}
