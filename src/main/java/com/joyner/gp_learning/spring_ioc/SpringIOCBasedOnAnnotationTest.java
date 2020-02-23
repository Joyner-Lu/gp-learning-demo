package com.joyner.gp_learning.spring_ioc;

import com.joyner.gp_learning.mvcframework.demo.service.impl.DemoService;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
public class SpringIOCBasedOnAnnotationTest {



    public static void main(String[] args) {


        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        DemoService demoService = annotationConfigApplicationContext.getBean(DemoService.class);
        System.out.println(demoService.get("test annotation"));

    }
}
