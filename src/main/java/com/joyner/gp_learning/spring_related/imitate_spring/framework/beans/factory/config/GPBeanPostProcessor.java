package com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.config;

import com.joyner.gp_learning.spring_related.imitate_spring.framework.context.GPAbstractApplicationContext;
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

    public GPAbstractApplicationContext applicationContext;

    public GPBeanPostProcessor(GPAbstractApplicationContext applicationContext) {
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
        return bean;
    }
}
