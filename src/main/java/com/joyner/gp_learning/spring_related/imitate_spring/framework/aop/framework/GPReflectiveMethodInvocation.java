package com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.framework;

import com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.intercept.GPJoinPoint;
import com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.intercept.GPMethodInterceptor;
import lombok.Data;

import java.lang.reflect.Method;
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
@Data
public class GPReflectiveMethodInvocation implements GPJoinPoint {

    private Object proxy;
    private Object target;
    private Class targetClass;
    private Method method;
    private Object[] arguments;
    private List<Object> interceptorsAndDynamicMethodMatchers;
    /**
     * Index from 0 of the current interceptor we're invoking.
     * -1 until we invoke: then the current interceptor.
     */
    private int currentInterceptorIndex = -1;

    public GPReflectiveMethodInvocation(
            Object proxy, Object target, Method method,Object[] arguments,
            Class<?> targetClass, List<Object> interceptorsAndDynamicMethodMatchers) {

        this.proxy = proxy;
        this.target = target;
        this.targetClass = targetClass;
        this.method = method;
        this.arguments = arguments;
        this.interceptorsAndDynamicMethodMatchers = interceptorsAndDynamicMethodMatchers;
    }


    public Object proceed() {
        //	We start with an index of -1 and increment early.
        if (this.currentInterceptorIndex == this.interceptorsAndDynamicMethodMatchers.size() - 1) {
            return invokeJoinpoint();
        }

        Object interceptorOrInterceptionAdvice =
                this.interceptorsAndDynamicMethodMatchers.get(++this.currentInterceptorIndex);
        if (interceptorOrInterceptionAdvice instanceof GPMethodInterceptor) {
            GPMethodInterceptor methodInterceptor = (GPMethodInterceptor)interceptorOrInterceptionAdvice;
            Object result = methodInterceptor.invoke(this);
            return result;
        } else {
            proceed();
        }
        return null;
    }

    private Object invokeJoinpoint() {
        try {
            return this.method.invoke(this.target, this.arguments);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Object getThis() {
        return this.target;
    }


}
