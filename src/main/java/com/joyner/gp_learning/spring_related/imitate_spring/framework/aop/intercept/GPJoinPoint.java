package com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.intercept;

import java.lang.reflect.AccessibleObject;
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
public interface GPJoinPoint {

    /**
     * Return the object that holds the current joinpoint's static part.
     * <p>For instance, the target object for an invocation.
     * @return the object (can be null if the accessible object is static)
     */
    Object getThis();

    Method getMethod();

    Object[] getArguments();
}
