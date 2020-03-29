package com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.framework;

import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.aop.support.AopUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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
public class GPJdkDynamicAopProxy implements GPAopProxy,InvocationHandler {


    private GPAdvisedSupport advised;

    public GPJdkDynamicAopProxy(GPAdvisedSupport gpAdvisedSupport) {
        this.advised = gpAdvisedSupport;
    }

    @Override
    public Object getProxy() {
        ClassLoader classLoader = advised.getTargetClass().getClassLoader();
        return Proxy.newProxyInstance(classLoader, advised.getTargetClass().getInterfaces(), this);
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return null;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Get the interception chain for this method.
        List<Object> chain = this.advised.getInterceptorsAndDynamicInterceptionAdvice(method, this.advised.getTargetClass());
        Object retVal = null;
        // Check whether we have any advice. If we don't, we can fallback on direct
        // reflective invocation of the target, and avoid creating a MethodInvocation.
        if (chain != null && !chain.isEmpty()) {
            // We need to create a method invocation...
            GPReflectiveMethodInvocation invocation = new GPReflectiveMethodInvocation(proxy, advised.getTarget(), method, args, advised.getTargetClass(), chain);
            // Proceed to the joinpoint through the interceptor chain.
            retVal = invocation.proceed();
        } else {
            retVal = method.invoke(advised.getTarget(), args);
        }
        
        return retVal;
    }
}
