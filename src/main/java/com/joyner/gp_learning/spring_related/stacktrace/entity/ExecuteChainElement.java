package com.joyner.gp_learning.spring_related.stacktrace.entity;

import lombok.Data;

import java.lang.reflect.Method;

/**
 * <pre>
 * 调用链元素
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
public class ExecuteChainElement {

    public ExecuteChainElement(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    public ExecuteChainElement(Object target, Method method, Object[] args, Exception ex) {
        this.target = target;
        this.method = method;
        this.args = args;
        this.ex = ex;
    }

    private Object target;
    private Method method;
    private Object[] args;
    private Exception ex;
}
