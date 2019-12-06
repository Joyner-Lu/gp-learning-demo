package com.joyner.gp_learning.design_pattern.singleton.hungry;

import com.joyner.gp_learning.custom_classloader.MyClassLoader;

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
public class HungryStaticSingletonTest {

    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class clz = Class.forName("com.joyner.gp_learning.design_pattern.singleton.hungry.HungryStaticSingleton", true, myClassLoader);
        System.out.println(clz.getClassLoader());
        Constructor constructor = clz.getDeclaredConstructor();
        constructor.setAccessible(true);
        HungryStaticSingleton h1 = (HungryStaticSingleton)constructor.newInstance();
        System.out.println(h1);
        HungryStaticSingleton hungryStaticSingleton = HungryStaticSingleton.getInstance();
        System.out.println(hungryStaticSingleton);


    }


    public static void testSerializableProof() throws Exception{
        HungryStaticSingleton hungryStaticSingleton = HungryStaticSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" +  hungryStaticSingleton);
        ObjectOutput  objectOutput = new ObjectOutputStream(new FileOutputStream("HungryStaticSingleton"));
        objectOutput.writeObject(hungryStaticSingleton);

        ObjectInput objectInput = new ObjectInputStream(new FileInputStream("HungryStaticSingleton"));
        HungryStaticSingleton h1 = (HungryStaticSingleton)objectInput.readObject();
        System.out.println(h1);
    }
}

class HungryStaticSingletonRunnable implements Runnable {
    @Override
    public void run() {
        HungryStaticSingleton hungryStaticSingleton = HungryStaticSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + hungryStaticSingleton);
    }
}