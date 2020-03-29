package com.joyner.gp_learning.spring_related.imitate_spring.demo.aspect;

import com.joyner.gp_learning.spring_related.imitate_spring.framework.aop.intercept.GPJoinPoint;

/**
 * Created by Tom on 2019/4/14.
 */
public class LogAspect {

    public void before(GPJoinPoint joinPoint){
        //往对象里面记录调用的开始时间
        System.out.println("====开始执行before");
    }

    public void after(GPJoinPoint joinPoint){
        //系统当前时间-之前记录的开始时间=方法的调用所消耗的时间
        //就能够监测出方法执行性能
        System.out.println("====开始执行after");
    }

    public void afterThrowing(GPJoinPoint joinPoint,Throwable ex){
        //异常监测，我可以拿到异常的信息
        System.out.println("====开始执行afterThrowing");

    }

}
