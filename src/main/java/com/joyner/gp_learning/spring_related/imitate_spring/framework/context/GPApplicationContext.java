package com.joyner.gp_learning.spring_related.imitate_spring.framework.context;

import com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.config.GPBeanDefinition;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.config.GPBeanPostProcessor;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.support.GPBeanDefinitionReader;

import java.util.List;

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
public class GPApplicationContext extends GPAbstractApplicationContext {

    private String[] configLocations;
    private GPBeanDefinitionReader beanDefinitionReader;

    public GPApplicationContext(String... configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    public void refresh() {
        //1、定位，定位配置文件
        beanDefinitionReader = new GPBeanDefinitionReader(this.configLocations);
        //2、加载配置文件，扫描相关的类，把它们封装成
        List<GPBeanDefinition> beanDefinitions = beanDefinitionReader.loadBeanDefinitions();
        //3、注册，把配置信息放到容器里面(伪 IOC 容器)
        doRegisterBeanDefinition(beanDefinitions);
        //4、把不是延时加载的类，有提前初始化
        doAutowired(beanDefinitions);

    }

    private void doAutowired(List<GPBeanDefinition> beanDefinitions) {
        for (GPBeanDefinition beanDefinition : beanDefinitions) {
            if (!beanDefinition.isLazyInit()) {
                getBean(beanDefinition.getBeanName());
            }
        }
    }

    private void doRegisterBeanDefinition(List<GPBeanDefinition> beanDefinitions) {
        try {
            for (GPBeanDefinition beanDefinition : beanDefinitions) {
                registerBeanDefinition(beanDefinition.getBeanName(), beanDefinition);
                //把类名也注册进去
                //方便getBean(Class clz)处理
                registerBeanDefinition(beanDefinition.getBeanClassName(), beanDefinition);
                //把起接口的的名称也作为beanName添加进去，方便处理
                Class clz = Class.forName(beanDefinition.getBeanClassName());
                Class<?>[] interfaces =  clz.getInterfaces();
                for (Class<?> anInterface : interfaces) {
                    registerBeanDefinition(anInterface.getName(), beanDefinition);
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public <T> T getBean(Class<T> clz) {
        return getBeanFactory().getBean(clz);
    }

    @Override
    public Object getBean(String beanName) {
        return getBeanFactory().getBean(beanName);
    }

    @Override
    public GPBeanDefinition getBeanDefinition(String beanName) {
        return getBeanFactory().getBeanDefinition(beanName);
    }

    @Override
    public void setBeanPostProcessor(GPBeanPostProcessor beanPostProcessor) {
        getBeanFactory().setBeanPostProcessor(beanPostProcessor);
    }

    @Override
    public GPBeanPostProcessor getBeanPostProcessor() {
        return getBeanFactory().getBeanPostProcessor();
    }
}
