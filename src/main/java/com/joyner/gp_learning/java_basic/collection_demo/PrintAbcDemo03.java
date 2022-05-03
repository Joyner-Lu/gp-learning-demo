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
public class PrintAbcDemo03 {



    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        final Object lock = new Object();
        new Thread(()->{
            synchronized (lock) {
                for(char c : aI) {
                    System.out.println(c);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
                lock.notify();
            }
        }, "t1").start();

        new Thread(()->{
            synchronized (lock) {
                for(char c : aC) {
                    System.out.println(c);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                lock.notify();
            }

        }, "t2").start();


    }

}
