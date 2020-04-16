package com.joyner.gp_learning.java_basic.type_learning;

import com.joyner.gp_learning.design_pattern.proxy.Person;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

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
public class GenericArrayTypeBean<T> {


    public void test(List<String>[] pTypeArray, T[] vTypeArray,
                     List<String> list, String[] strings, Person[] ints) {
    }

    public static void testGenericArrayType() throws Exception {
        Method method = GenericArrayTypeBean.class.getDeclaredMethods()[1];
        System.out.println(method);
        // public void test(List<String>[] pTypeArray, T[]
        // vTypeArray,List<String> list, String[] strings, Person[] ints)
        Type[] types = method.getGenericParameterTypes(); // 这是 Method 中的方法
        for (Type type : types) {
            System.out.println(type instanceof GenericArrayType);// 依次输出true，true，false，false，false
        }
    }

    public static void main(String[] args) throws Exception {
        testGenericArrayType();
    }


}
