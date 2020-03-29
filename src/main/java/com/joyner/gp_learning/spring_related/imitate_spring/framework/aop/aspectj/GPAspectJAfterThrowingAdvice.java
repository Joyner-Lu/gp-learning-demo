package com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.aspectj;

import com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.framework.GPReflectiveMethodInvocation;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.intercept.GPMethodInterceptor;

import java.lang.reflect.Method;

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
public class GPAspectJAfterThrowingAdvice extends GPAspectJAbstractAdvice implements GPAdvice,GPMethodInterceptor {

    private String aspectAfterThrowingName;

    public GPAspectJAfterThrowingAdvice(Method aspectMethod, Object aspectInstance) {
        super(aspectMethod, aspectInstance);
    }

    @Override
    public Object invoke(GPReflectiveMethodInvocation invocation) {
        try {
            return invocation.proceed();
        } catch (Exception ex) {
            invokeAfterThrowing(invocation,ex);
            throw new RuntimeException(ex);
        }
    }

    private void invokeAfterThrowing(GPReflectiveMethodInvocation invocation, Exception ex) {
        invokeAspectMethod(invocation, null, ex);
    }

    public void setAspectAfterThrowingName(String aspectAfterThrowingName) {
        this.aspectAfterThrowingName = aspectAfterThrowingName;
    }
}
