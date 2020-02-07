package com.joyner.gp_learning.design_pattern.proxy.jdkproxy;

import com.joyner.gp_learning.design_pattern.proxy.Person;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

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
public class JDKProxyTest {

    public static void main(String[] args) throws Exception {
        JDKMeipo jdkMeipo = new JDKMeipo();
        Person person = (Person) jdkMeipo.getInstance(new Customer());
        person.findLove();

        //将class磁盘
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
        FileOutputStream fileOutputStream = new FileOutputStream("D:/$Proxy0.class");
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
