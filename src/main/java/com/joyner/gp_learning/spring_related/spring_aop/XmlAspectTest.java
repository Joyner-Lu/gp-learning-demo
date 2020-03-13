package com.joyner.gp_learning.spring_related.spring_aop;

import com.joyner.gp_learning.design_pattern.proxy.Person;
import com.joyner.gp_learning.spring_related.spring_aop.target.AspectServiceDemo;
import com.joyner.gp_learning.spring_related.spring_aop.target.IAspectServiceDemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
public class XmlAspectTest {

    /**
     * try{
     *     try{
     *         //@Before
     *         method.invoke(..);
     *     }finally{
     *         //@After
     *     }
     *     //@AfterReturning
     * }catch(){
     *     //@AfterThrowing
     * }
     * @param args
     */

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-aop.xml");
        IAspectServiceDemo demo = applicationContext.getBean(IAspectServiceDemo.class);
        /**
         * jdk方式
         */
        byte[] bytes = ProxyGenerator.generateProxyClass(demo.getClass().getSimpleName(), new Class[]{IAspectServiceDemo.class});
        FileOutputStream fileOutputStream = new FileOutputStream("D:/"+demo.getClass().getSimpleName()+".class");
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();
        demo.doSave();
    }
}
