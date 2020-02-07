package com.joyner.gp_learning.design_pattern.proxy.gpproxy;

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
public class GPMeipo implements GPInvocationHandler {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class clz = target.getClass();
        return GPProxy.newProxyInstance(new GPClassLoader(), clz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object r = method.invoke(target, args);
        after();
        return r;
    }

    private void after() {
        System.out.println("after");
    }

    private void before() {
        System.out.println("before");
    }
}
