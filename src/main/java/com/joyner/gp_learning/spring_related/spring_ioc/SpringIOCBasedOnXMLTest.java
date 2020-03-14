package com.joyner.gp_learning.spring_related.spring_ioc;

import com.joyner.gp_learning.spring_related.mvcframework.demo.service.impl.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ResolvableType;

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
public class SpringIOCBasedOnXMLTest {

    private String str = "";

    public SpringIOCBasedOnXMLTest() {
        test11(this);
        this.str = "test";
    }

    public void test11(SpringIOCBasedOnXMLTest springIOCTest) {
        System.out.println("val:" + springIOCTest.str);
    }

    public static void main(String[] args) {


        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("beans.xml");
        DemoService demoService =  beanFactory.getBean(DemoService.class);
        System.out.println(demoService.get("joyner"));
        ResolvableType type = ResolvableType.forClass(DemoService.class);
        boolean f = beanFactory.isTypeMatch("demoService", type);
        System.out.println(f);

        System.out.println(beanFactory.getType("demoService"));



    }
}
