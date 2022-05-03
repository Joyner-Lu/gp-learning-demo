package com.joyner.gp_learning.java_basic.collection_demo;

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
public class PrintAbcDemo02LockSupport {

    private static volatile boolean isAbcStarted = false;

    class PrintAbcThread extends Thread {

        private Print123Thread _123_t = null;

        public void set_123_t(Print123Thread _123_t) {
            this._123_t = _123_t;
        }

        private char a =  'A';
        private int idx = 0;
        @Override
        public void run() {
            while (idx < 26) {
                System.out.println(a);
                a++;
                idx++;
                LockSupport.unpark(_123_t);
                LockSupport.park();
            }

        }
    }

    class Print123Thread extends Thread {

        private PrintAbcThread _abc_t = null;


        public void set_abc_t(PrintAbcThread _abc_t) {
            this._abc_t = _abc_t;
        }

        private int i = 1;
        private int idx = 0;
        @Override
        public void run() {
            while (idx < 26) {
                LockSupport.park();
                System.out.println(i);
                i++;
                idx++;
                LockSupport.unpark(_abc_t);
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintAbcDemo02LockSupport printAbcDemo = new PrintAbcDemo02LockSupport();
        PrintAbcThread printAbcThread = null;
        Print123Thread print123Thread = null;
        print123Thread = printAbcDemo.new Print123Thread();
        printAbcThread = printAbcDemo.new PrintAbcThread();
        print123Thread.set_abc_t(printAbcThread);
        printAbcThread.set_123_t(print123Thread);
        printAbcThread.start();
        print123Thread.start();
        print123Thread.join();
        printAbcThread.join();
    }

}
