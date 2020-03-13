package com.joyner.gp_learning.design_pattern.proxy.cglibproxy;

import net.sf.cglib.core.ReflectUtils;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

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
public class CGLibMeipo implements MethodInterceptor {

    public Object getInstance(Class clz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clz);
        enhancer.setCallback(this);
        return enhancer.create();


    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) {
        try {

            before();
            Object r = methodProxy.invokeSuper(obj, args);
            after();
            return r;
        }catch (Throwable ex) {
            throw new RuntimeException(ex);
        }

    }

    private void before() {
        System.out.println("我是媒婆，已经拿到你的需求");
        System.out.println("开始物色");
    }

    private void after() {
        System.out.println("如果合适的话就开始办事");
    }


}
