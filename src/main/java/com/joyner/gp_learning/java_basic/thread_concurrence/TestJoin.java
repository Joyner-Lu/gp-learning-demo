package com.joyner.gp_learning.java_basic.thread_concurrence;

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
public class TestJoin {

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }

        });
        t.start();
        t.join();
        t.stop();
        System.out.println("main thread");
    }
}
