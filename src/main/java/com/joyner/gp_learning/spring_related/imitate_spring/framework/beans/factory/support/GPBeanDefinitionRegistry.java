package com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.support;

import com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.config.GPBeanDefinition;

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
public interface GPBeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, GPBeanDefinition beanDefinition);

    GPBeanDefinition getBeanDefinition(String beanName);
}
