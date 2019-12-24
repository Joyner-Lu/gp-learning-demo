package com.joyner.gp_learning.custom_classloader;

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
public class MainTest {

    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader =  new MyClassLoader();
        Class c = Class.forName("com.joyner.gp_learning.custom_classloader.ITest01",true, myClassLoader);
        System.out.println("类加载器是：" + c.getClassLoader());

        MyClassLoaderV2 myClassLoaderV2 = new MyClassLoaderV2();
        Class c1 = Class.forName("com.joyner.gp_learning.custom_classloader.ITest01",true, myClassLoaderV2);
        System.out.println("类加载器是：" + c1.getClassLoader());

        System.out.println(c.equals(c1));
    }
}
