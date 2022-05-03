package com.joyner.gp_learning.juc.thread;

import java.util.concurrent.TimeUnit;

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
public class InterruptDemo {

    private static int i;

    public static void
    main(String[] args) throws
            InterruptedException {
        Thread thread = new
                Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("finished.");
        }, "interruptDemo");
        thread.start();
        TimeUnit.SECONDS.sleep(6);

        thread.interrupt();
    }
}