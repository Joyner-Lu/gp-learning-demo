package com.joyner.gp_learning.spring_related.spring_bean_lifecycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.UUID;


public class BeanLifeCycleTest {
    private static void LifeCycleInBeanFactory(){
 	   Resource res = new ClassPathResource("bean-life-cycle.xml");
       BeanFactory bf = new XmlBeanFactory(res);
       (new MyBeanFactoryPostProcessor()).postProcessBeanFactory((XmlBeanFactory)bf);
       //InstantiationAwareBeanPostProcessor
       ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor()); 
       //BeanPostProcessor
       ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());             
       Car car1 = (Car)bf.getBean("car");
       car1.introduce();
       car1.setColor("红色");
       Car car2 = bf.getBean("car",Car.class);
       car2.introduce();

        String[] beanDefinitionNames = ((XmlBeanFactory) bf).getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println("=>" + name);
        }
        ((XmlBeanFactory)bf).destroySingletons();
    }

    private static void applicationTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-life-cycle.xml");
        Car car1 = (Car)applicationContext.getBean("car");
        System.out.println(car1.getColor());
    }

	public static void main(String[] args) {
        /*applicationTest();*/
        LifeCycleInBeanFactory();
    }
}
