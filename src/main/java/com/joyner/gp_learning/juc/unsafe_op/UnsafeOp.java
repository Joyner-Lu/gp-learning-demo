package com.joyner.gp_learning.juc.unsafe_op;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <pre>
 *  Unsafe类操作
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
public class UnsafeOp {

    volatile int i = 0;

    private static Unsafe unsafe = null;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        int count = 10000;

        UnsafeOp unsafeOp = new UnsafeOp();
        long iOffset = unsafe.objectFieldOffset
                (UnsafeOp.class.getDeclaredField("i"));
        Thread t1 = new Thread(() -> {
            int i = 0;
            while (i < count) {
                boolean b = unsafe.compareAndSwapInt(unsafeOp, iOffset, unsafeOp.i, unsafeOp.i + 1);
                if (b) {
                    int r = unsafe.getIntVolatile(unsafeOp, iOffset);
                    System.out.println(r);
                }


                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        });
        t1.start();

        Thread t2 = new Thread(() -> {
            int i = 0;
            while (i < count) {
                boolean b = unsafe.compareAndSwapInt(unsafeOp, iOffset, unsafeOp.i, unsafeOp.i + 1);
                if (b) {
                    int r = unsafe.getIntVolatile(unsafeOp, iOffset);
                    System.out.println(r);
                }

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        });
        t2.start();
        t1.join();
        t2.join();
        //System.out.println("main:" + unsafeOp.i);
    }
}
