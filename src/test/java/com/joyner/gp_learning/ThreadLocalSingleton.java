package com.joyner.gp_learning;

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
public class ThreadLocalSingleton {

    private static ThreadLocal<ThreadLocalSingleton> threadLocalSingletonThreadLocal = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return new ThreadLocalSingleton();
        }
    };


    private ThreadLocalSingleton() {

    }

    public static ThreadLocalSingleton getInstance() {
        return threadLocalSingletonThreadLocal.get();
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
