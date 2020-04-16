package com.joyner.gp_learning.java_basic.type_learning;

import java.lang.reflect.Type;

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
public class PrintUtils {

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void printTypeArr(Type[] typeArr) {
        for (Type type : typeArr) {
            System.out.println(type);
        }

    }
}
