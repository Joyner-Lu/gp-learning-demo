package com.joyner.gp_learning.java_basic.thread_concurrence;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

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
public class CrossPrintTestV2 {


    public static void main(String[] args) throws Exception {
        CrossPrintTestV2 crossPrintTest = new CrossPrintTestV2();
        crossPrintTest.run();

    }
    static Thread t1 = null, t2 = null;
    public void run() throws Exception {


        t1 = new Thread(() -> {
            try {
                char c = 'A';
                for (int j = 0; j < 26; j++) {
                    System.out.println((char) (c + j));
                    LockSupport.park();
                    LockSupport.unpark(t2);
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            } finally {

            }

        }, "T1");

        t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 26; i++) {
                    System.out.println(i + 1);
                    LockSupport.unpark(t1);
                    LockSupport.park();
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }, "T2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("---------------------------------");
    }

}
