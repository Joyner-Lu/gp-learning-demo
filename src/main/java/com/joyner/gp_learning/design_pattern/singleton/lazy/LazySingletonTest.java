package com.joyner.gp_learning.design_pattern.singleton.lazy;

import com.joyner.gp_learning.design_pattern.singleton.hungry.LazySingletonWithInnerClass;

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
public class LazySingletonTest {

    public static void main(String[] args) throws Exception{

        //testWithSynchronized();
        // testWithDoubleCheck();
        testWithInnerClass();
    }

    private static void testWithInnerClass() throws Exception{
       /* Constructor c = LazySingletonWithInnerClass.class.getDeclaredConstructor();
        c.setAccessible(true);
        Object o = c.newInstance();
        System.out.println(o);*/

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingletonWithInnerClass lazySingletonWithInnerClass = LazySingletonWithInnerClass.getInstance();

                System.out.println(Thread.currentThread() + "-" + lazySingletonWithInnerClass);
            }
        });
        t.start();
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingletonWithInnerClass lazySingletonWithInnerClass = LazySingletonWithInnerClass.getInstance();
                System.out.println(Thread.currentThread() + "-" + lazySingletonWithInnerClass);
            }
        });
        t.start();
    }

    private static void testWithDoubleCheck() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingletonWithDoubleCheck lazySingletonWithDoubleCheck = LazySingletonWithDoubleCheck.getInstance();

                System.out.println(Thread.currentThread() + "-" + lazySingletonWithDoubleCheck);
            }
        });
        t.start();
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingletonWithDoubleCheck lazySingletonWithDoubleCheck = LazySingletonWithDoubleCheck.getInstance();
                System.out.println(Thread.currentThread() + "-" + lazySingletonWithDoubleCheck);
            }
        });
        t.start();
    }

    private static void testWithSynchronized() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingletonWithSynchronized lazySingletonWithSynchronized = LazySingletonWithSynchronized.getInstance();

                System.out.println(Thread.currentThread() + "-" + lazySingletonWithSynchronized);
            }
        });
        t.start();
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingletonWithSynchronized lazySingletonWithSynchronized = LazySingletonWithSynchronized.getInstance();
                System.out.println(Thread.currentThread() + "-" + lazySingletonWithSynchronized);
            }
        });
        t.start();
    }

    private static void testWithUnsafe() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingletonWithUnsafe lazySingletonWithUnsafe = LazySingletonWithUnsafe.getInstance();
                System.out.println(Thread.currentThread() + "-" + lazySingletonWithUnsafe);
            }
        });
        t.start();
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingletonWithUnsafe lazySingletonWithUnsafe = LazySingletonWithUnsafe.getInstance();
                System.out.println(Thread.currentThread() + "-" + lazySingletonWithUnsafe);
            }
        });
        t.start();
    }
}
