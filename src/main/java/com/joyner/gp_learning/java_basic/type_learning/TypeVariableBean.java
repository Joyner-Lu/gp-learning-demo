package com.joyner.gp_learning.java_basic.type_learning;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.net.Proxy;
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
public class TypeVariableBean<K extends InputStream & Closeable, V> {
    // K 的上边界是 InputStream
    K key;
    // 没有指定的话 ，V 的 上边界 属于 Object
    V value;
    // 不属于 TypeTypeVariable
    V[] values;
    String str;
    List<K> kList;

    public static void main(String[] args) throws Exception {
        TypeVariableBean bean = new TypeVariableBean<FileInputStream, String>();
        Field fk = TypeVariableBean.class.getDeclaredField("key");
        TypeVariable keyType = (TypeVariable) fk.getGenericType();
        System.out.println(keyType.getName());
        System.out.println(keyType.getGenericDeclaration());

    }
}
