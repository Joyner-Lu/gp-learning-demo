package com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.aspectj;

import com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.intercept.GPJoinPoint;
import lombok.Data;

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
@Data
public abstract class GPAspectJAbstractAdvice {

    private Method aspectMethod;
    private Object aspectInstance;


    public GPAspectJAbstractAdvice(Method aspectMethod, Object aspectInstance) {
        this.aspectMethod = aspectMethod;
        this.aspectInstance  = aspectInstance;
    }

    public Object invokeAspectMethod(GPJoinPoint joinPoint, Object returnValue, Throwable ex) {
        try {
            Class[] parameterTypes = aspectMethod.getParameterTypes();
            Object[] args = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                Class type = parameterTypes[i];
                if (type == GPJoinPoint.class) {
                    args[i] = joinPoint;
                } else if (type == Object.class) {
                    args[i] = returnValue;
                } else if (type == Throwable.class) {
                    args[i] = ex;
                }
            }
            return aspectMethod.invoke(aspectInstance, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
