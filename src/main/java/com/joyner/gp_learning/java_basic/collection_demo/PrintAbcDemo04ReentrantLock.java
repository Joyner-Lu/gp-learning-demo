package com.joyner.gp_learning.java_basic.collection_demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

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
public class PrintAbcDemo04ReentrantLock {



    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        ReentrantLock reentrantLock = new ReentrantLock();
        Condition signal = reentrantLock.newCondition();

        new Thread(()->{
            reentrantLock.lock();
            try {
                for(char c : aI) {
                    System.out.println(c);
                    try {
                        signal.signal();
                        signal.await();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
                signal.signal();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }

        }, "t1").start();

        new Thread(()->{
            reentrantLock.lock();
            try {
                for(char c : aC) {
                    System.out.println(c);
                    try {
                        signal.signal();
                        signal.await();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                signal.signal();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }

        }, "t2").start();


    }

}
