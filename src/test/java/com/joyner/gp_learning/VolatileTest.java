package com.joyner.gp_learning;

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
/**
 * volatile变量自增运算测试
 *
 * @author zzm
 */
public class VolatileTest {

    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 2; i++) {
                        increase();
                    }
                    System.out.println(Thread.currentThread().getName() + "-over");
                }
            });
            threads[i].start();
        }
        boolean flag = true;
        // 等待所有累加线程都结束
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }


        System.out.println(race);
    }
}

