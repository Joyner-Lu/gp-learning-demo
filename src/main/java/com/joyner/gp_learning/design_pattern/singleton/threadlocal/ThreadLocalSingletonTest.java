package com.joyner.gp_learning.design_pattern.singleton.threadlocal;

import java.lang.reflect.Constructor;

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
public class ThreadLocalSingletonTest {

    public static void main(String[] args) throws Exception {
        Constructor c = ThreadLocalSingleton.class.getDeclaredConstructor();
        c.setAccessible(true);
        System.out.println(Thread.currentThread().getName() + " --" + c.newInstance());

        System.out.println(Thread.currentThread().getName() + " --" + ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName() + " --" + ThreadLocalSingleton.getInstance());

        System.out.println(Thread.currentThread().getName() + " --" + ThreadLocalSingleton.getInstance());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " --" + ThreadLocalSingleton.getInstance());

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " --" + ThreadLocalSingleton.getInstance());

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " --" + ThreadLocalSingleton.getInstance());

            }
        }).start();

    }
}
