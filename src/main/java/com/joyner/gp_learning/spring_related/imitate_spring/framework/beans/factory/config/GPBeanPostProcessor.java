package com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.config;

import com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.framework.GPAdvisedSupport;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.framework.GPAopProxy;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.framework.GPCglibAopProxy;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.framework.GPJdkDynamicAopProxy;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.context.GPAbstractApplicationContext;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.context.GPApplicationContext;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.context.GPApplicationContextAware;
import org.springframework.lang.Nullable;

/**
 * <pre>
 *  暂时简单实现
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
public class GPBeanPostProcessor {

    public GPApplicationContext applicationContext;

    public GPBeanPostProcessor(GPApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        //1.处理实现了GPApplicationContextAware的bean
        if (bean instanceof GPApplicationContextAware) {
            ((GPApplicationContextAware)bean).setApplicationContext(applicationContext);
        }

        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) {
        //在这里进行代理的处理
        bean = wrapIfNecessary(bean, beanName);
        return bean;
    }

    private Object wrapIfNecessary(Object bean, String beanName) {
        GPAdvisedSupport advised = new GPAdvisedSupport(this.applicationContext.getAopConfig());
        advised.setTarget(bean);
        if (advised.pointCutMatch()) {
            GPAopProxy gpAopProxy = createProxy(advised);
            bean = gpAopProxy.getProxy();
        }
        return bean;
    }

    private GPAopProxy createProxy(GPAdvisedSupport advised) {
        Class[] interfaces = advised.getTargetClass().getInterfaces();
        if (interfaces != null && interfaces.length > 0) {
            return new GPJdkDynamicAopProxy(advised);
        }
        return new GPCglibAopProxy();
    }
}
