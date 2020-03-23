package com.joyner.gp_learning.spring_related.spring_ioc;

import com.joyner.gp_learning.spring_related.springmvc_mini.demo.service.IDemoService;
import com.joyner.gp_learning.spring_related.springmvc_mini.demo.service.impl.DemoService;
import com.joyner.gp_learning.spring_related.stacktrace.core.StackTraceBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
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


    public static void main(String[] args) {

        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("beans.xml");
        IDemoService demoService =  beanFactory.getBean(IDemoService.class);
        demoService.get("测试");
    }
}
