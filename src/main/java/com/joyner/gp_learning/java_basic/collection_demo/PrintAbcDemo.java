package com.joyner.gp_learning.java_basic.collection_demo;

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
public class PrintAbcDemo {

    private Object lock = new Object();
    private static volatile boolean isAbcStarted = false;

    class PrintAbcThread extends Thread {
        private char a =  'A';
        private int idx = 0;
        @Override
        public void run() {
            while (idx < 26) {
                System.out.println(a);
                a++;
                idx++;
                synchronized (lock) {
                    try {
                        isAbcStarted = true;//运行到了这里，证明a拿到了锁。
                        lock.wait();
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    class Print123Thread extends Thread {

        private int i = 1;
        private int idx = 0;
        @Override
        public void run() {
            while (idx < 26) {
                while (!isAbcStarted){}//确保abc先运行
                System.out.println(i);
                i++;
                idx++;
                synchronized (lock) {
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintAbcDemo printAbcDemo = new PrintAbcDemo();
        Print123Thread print123Thread = printAbcDemo.new Print123Thread();
        PrintAbcThread printAbcThread = printAbcDemo.new PrintAbcThread();
        printAbcThread.start();
        print123Thread.start();
        print123Thread.join();
        printAbcThread.join();
    }

}
