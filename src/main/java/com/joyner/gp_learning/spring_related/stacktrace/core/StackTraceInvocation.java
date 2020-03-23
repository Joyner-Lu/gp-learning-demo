package com.joyner.gp_learning.spring_related.stacktrace.core;

import com.joyner.gp_learning.spring_related.stacktrace.entity.ExecuteChainElement;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

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
public class StackTraceInvocation implements InvocationHandler {

    private Object target;
    private static ThreadLocal<Deque<ExecuteChainElement>>  executeChainStack = new ThreadLocal<>();
    //类名加方法名
    private static ThreadLocal<String> executeEntrance = new ThreadLocal<String>();


    public StackTraceInvocation(Object target) {
        this.target = target;
    }

    public Object getInstance() {
        Object proxyInstance = Proxy.newProxyInstance(this.target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return proxyInstance;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        try {
            //1.调用之前把执行参数和方法都存储起来
            //2.把调用入口类保存起来
            Deque<ExecuteChainElement> stack = executeChainStack.get();
            if (stack == null) {
                executeEntrance.set(this.target.getClass().getName() + "." + method.getName());
                stack = new ArrayDeque<ExecuteChainElement>();
                //开始设置
                executeChainStack.set(stack);
            }
            ExecuteChainElement executeChainElement = new ExecuteChainElement(this.target, method, args);
            stack.push(executeChainElement);
            Object result = method.invoke(target, args);
            return result;
        } catch (Exception ex) {
            //3.发生异常，对调用栈进行输出
            Deque<ExecuteChainElement> stack = executeChainStack.get();

            while (!stack.isEmpty()) {
                ExecuteChainElement executeChainElement = stack.pop();
                String methodArgs = processMethodArgs(executeChainElement.getArgs());
                System.out.println("======:" + executeChainElement.getTarget().getClass().getName() + "." +executeChainElement.getMethod().getName() + ",方法入参：" + methodArgs);
            }


            throw new RuntimeException(ex);
        } finally {
            clearExecuteChainStack(method);
        }
    }

    private String processMethodArgs(Object[] args) {
        if (args == null || args.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object arg : args) {
            sb.append(arg.toString() + ",");
        }
        sb.setLength(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    private void clearExecuteChainStack(Method method) {
        String entrance = executeEntrance.get();
        if (entrance.equals(this.target.getClass().getName() +"." + method.getName())) {
            executeChainStack.remove();
        }
    }
}
