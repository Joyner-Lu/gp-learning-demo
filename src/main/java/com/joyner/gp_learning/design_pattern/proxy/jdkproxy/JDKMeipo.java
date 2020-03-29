package com.joyner.gp_learning.design_pattern.proxy.jdkproxy;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.DecoratingProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.MemoryHandler;

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
public class JDKMeipo implements InvocationHandler {

    private Object target;


    public Object getInstance(Object target) {
        this.target = target;
        Class clz = target.getClass();
        return  Proxy.newProxyInstance(clz.getClassLoader(), clz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if (methodName.contains("toString")) {
            System.out.println("=====真的执行了toString方法，而且是断点之前执行从");

            //idea的时候会执行toString方法，因此这里需要做处理
            //参考文章：http://bbs.itheima.com/thread-425254-1-1.html
            Method toStringMethod = this.target.getClass().getMethod("toString");
            return toStringMethod.invoke(this.target);
        }


        before();
        Object result = method.invoke(this.target, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("我是媒婆，已经拿到你的需求");
        System.out.println("开始物色");
    }

    private void after() {
        System.out.println("如果合适的话就开始办事");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
