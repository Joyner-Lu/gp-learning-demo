package com.joyner.gp_learning.spring_related.imitate_spring.framework.beans.factory.config;

import lombok.Data;

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
@Data
public class GPBeanDefinition {


    private String beanClassName;
    private boolean lazyInit = false;
    //为了方便扩展这个属性，源码是没有的。
    private String beanName;
    private String scope = GPBeanDefinitionScope.SINGLE_SCOPE;

    public boolean isSingleton() {
        if (GPBeanDefinitionScope.SINGLE_SCOPE.equals(this.scope)) {
            return true;
        }
        return false;
    }

    public static class GPBeanDefinitionScope {
        public static final String SINGLE_SCOPE = "single";
        public static final String PROTOTYPE_SCOPE = "prototype";
    }
}
