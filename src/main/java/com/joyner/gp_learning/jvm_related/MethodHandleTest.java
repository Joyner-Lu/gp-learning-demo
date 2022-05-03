package com.joyner.gp_learning.jvm_related;

import com.joyner.gp_learning.java_basic.type_learning.PrintUtils;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

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
public class MethodHandleTest {

    static class ClassA {
        public void println(String s) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        getPrintMH(obj).invokeExact("test");
    }

    public static MethodHandle getPrintMH(Object obj)throws Throwable {
        MethodType methodType = MethodType.methodType(void.class, String.class);
        MethodHandle methodHandle = MethodHandles.lookup().findVirtual(obj.getClass(), "println", methodType);
        return methodHandle;
    }

}
