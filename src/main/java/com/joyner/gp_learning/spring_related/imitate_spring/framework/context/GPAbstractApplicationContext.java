package com.joyner.gp_learning.spring_related.imitate_spring.framework.context;

import com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.GPBeanFactory;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.config.GPBeanDefinition;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.config.GPBeanPostProcessor;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.support.GPDefaultListableBeanFactory;

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
public abstract class GPAbstractApplicationContext implements GPBeanFactory {

    private GPBeanFactory gpBeanFactory;

    public GPAbstractApplicationContext() {
        gpBeanFactory = new GPDefaultListableBeanFactory();
        gpBeanFactory.setBeanPostProcessor(new GPBeanPostProcessor(this));
    }

    @Override
    public void registerBeanDefinition(String beanName, GPBeanDefinition beanDefinition) {
        gpBeanFactory.registerBeanDefinition(beanName, beanDefinition);
    }

    /**
     * 留给子类重写
     */
    public abstract void refresh();

    public GPBeanFactory getBeanFactory() {
        return gpBeanFactory;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }
}
