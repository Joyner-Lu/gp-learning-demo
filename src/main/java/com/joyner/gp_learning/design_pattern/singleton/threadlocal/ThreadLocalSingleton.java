package com.joyner.gp_learning.design_pattern.singleton.threadlocal;

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


    private static final ThreadLocal<ThreadLocalSingleton> threadLocal = new ThreadLocal<ThreadLocalSingleton>() {
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }

    };

    private ThreadLocalSingleton(){

    }


    public static ThreadLocalSingleton getInstance() {
        ThreadLocalSingleton threadLocalSingleton = threadLocal.get();
        return threadLocalSingleton;
    }

    /**
     * 防止序列号
     * @return
     */
    public Object readResolve() {
        return threadLocal.get();
    }
}
