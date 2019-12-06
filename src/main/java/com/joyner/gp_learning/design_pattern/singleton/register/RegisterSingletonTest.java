package com.joyner.gp_learning.design_pattern.singleton.register;

import java.io.*;
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
public class RegisterSingletonTest {


    public static void main(String[] args) throws Exception {
        //testWithReflection();
        testWithSerializable();
    }

    private static void testWithReflection() throws Exception {
        Constructor c = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);
        c.setAccessible(true);
        EnumSingleton enumSingleton = (EnumSingleton)c.newInstance();
        System.out.println(enumSingleton);
    }

    private static void testWithSerializable () throws Exception {
        EnumSingleton enumSingleton = EnumSingleton.getInstance();
        System.out.println(enumSingleton);
        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("EnumSingleton"));
        objectOutput.writeObject(enumSingleton);

        ObjectInput objectInput = new ObjectInputStream(new FileInputStream("EnumSingleton"));
        EnumSingleton enumSingleton1 = (EnumSingleton) objectInput.readObject();
        System.out.println(enumSingleton1 == enumSingleton);

    }
}
