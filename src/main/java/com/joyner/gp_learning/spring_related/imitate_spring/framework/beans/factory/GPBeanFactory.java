package com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory;

import com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.config.GPBeanPostProcessor;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.support.GPBeanDefinitionRegistry;
import org.springframework.beans.factory.config.BeanPostProcessor;

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
public interface GPBeanFactory extends GPBeanDefinitionRegistry {

    Object getBean(String beanName);

    <T> T getBean(Class<T> clz);

    void setBeanPostProcessor(GPBeanPostProcessor beanPostProcessor);

    GPBeanPostProcessor getBeanPostProcessor();

}
