package com.joyner.gp_learning.java_basic.thread_concurrence;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

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
public class CrossPrintTest {

    volatile boolean isFirst = false;


    public static void main(String[] args) throws Exception{
        CrossPrintTest crossPrintTest = new CrossPrintTest();
        crossPrintTest.run();


    }

    public void run() throws Exception{
        final Object lock = new Object();


        Thread t1 = new Thread(() -> {
            try {
                char c = 'A';
                for (int j = 0; j < 26; j++) {
                    System.out.println((char) (c + j));
                    synchronized (lock) {
                        isFirst = true;
                        lock.notify();
                        lock.wait();
                    }
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }, "T1");

        Thread t2 = new Thread(() -> {
            try {
                while (!isFirst) {
                    //确保T1先执行
                }
                for (int i = 0; i < 26; i++) {

                    System.out.println(i + 1);
                    synchronized (lock) {
                        lock.notify();
                        lock.wait();
                    }
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }, "T2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        isFirst = false;
        System.out.println("---------------------------------");
    }

}
