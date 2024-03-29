package com.joyner.gp_learning.spring_related.spring_bean_lifecycle;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("MyInstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");
        }
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation");
        }
        return true;
    }

    public PropertyValues postProcessPropertyValues(
            PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
            throws BeansException {
        if ("car".equals(beanName)) {
            Car c = (Car)bean;
            c.setBrand("postProcessPropertyValues setBrand");
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessPropertyValues,car:" + bean);
        }
        return pvs;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
