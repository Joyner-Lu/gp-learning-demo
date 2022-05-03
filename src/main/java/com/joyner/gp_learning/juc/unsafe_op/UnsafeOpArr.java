package com.joyner.gp_learning.juc.unsafe_op;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <pre>
 * 操作数组
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
public class UnsafeOpArr {

    private static Unsafe unsafe = null;
    private String[] table = {"1", "2", "3"};

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        UnsafeOpArr unsafeOpArr = new UnsafeOpArr();
        int base = unsafe.arrayBaseOffset(String[].class);
//获取数组中一个元素的大小(get size of an element in the array)
        int scale = unsafe.arrayIndexScale(String[].class);
        System.out.println(unsafe.getObject(unsafeOpArr.table, base + 1*scale));

        System.out.println("================");
        if ((scale & (scale - 1)) != 0)
            throw new Error("data type scale not a power of two");
        int asShift = 31 - Integer.numberOfLeadingZeros(scale);
        System.out.println(unsafe.getObject(unsafeOpArr.table, ((long)1 << asShift) + base));
    }
}
