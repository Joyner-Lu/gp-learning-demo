package com.joyner.gp_learning.design_pattern.singleton.hungry;

import com.joyner.gp_learning.custom_classloader.MyClassLoader;
import com.joyner.gp_learning.custom_classloader.MyClassLoaderV2;

import java.lang.reflect.Method;

/**
 * <pre>
 * 注意运行之前，要吧
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
public class SingletonWithDiffrentClassLoader {
    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class clz = Class.forName("com.joyner.gp_learning.design_pattern.singleton.hungry.HungryStaticSingleton", true, myClassLoader);
        Method method = clz.getMethod("getInstance");
        Object r = method.invoke(null);
        System.out.println(clz.getClassLoader()  + "====" + r);
        MyClassLoaderV2 myClassLoaderV2 = new MyClassLoaderV2();
        clz = Class.forName("com.joyner.gp_learning.design_pattern.singleton.hungry.HungryStaticSingleton", true, myClassLoaderV2);
        method = clz.getMethod("getInstance");
        r = method.invoke(null);
        System.out.println(clz.getClassLoader()  + "====" + r);
    }

}
