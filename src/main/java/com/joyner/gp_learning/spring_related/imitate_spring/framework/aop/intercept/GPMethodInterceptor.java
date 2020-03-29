package com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.intercept;

import com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.framework.GPReflectiveMethodInvocation;
import org.aopalliance.intercept.Joinpoint;
import org.aopalliance.intercept.MethodInvocation;

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
public interface GPMethodInterceptor {

    /**
     * Implement this method to perform extra treatments before and
     * after the invocation. Polite implementations would certainly
     * like to invoke {@link Joinpoint#proceed()}.
     * @param invocation the method invocation joinpoint
     * @return the result of the call to {@link Joinpoint#proceed()};
     * might be intercepted by the interceptor
     * @throws Throwable if the interceptors or the target object
     * throws an exception
     */
    Object invoke(GPReflectiveMethodInvocation invocation);
}
