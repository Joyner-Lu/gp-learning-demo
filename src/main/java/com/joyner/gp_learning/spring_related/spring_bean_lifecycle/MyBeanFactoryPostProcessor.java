package com.joyner.gp_learning.spring_related.spring_bean_lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) throws BeansException {
		BeanDefinition bd = bf.getBeanDefinition("car");
		bd.getPropertyValues().addPropertyValue("brand", "奇瑞QQ");
		System.out.println("调用MyBeanFactoryPostProcessor.postProcessBeanFactory()！设置brand为：奇瑞QQ");
	}

}
