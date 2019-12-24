package com.joyner.gp_learning;

import com.sun.org.apache.regexp.internal.RE;

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
public class InnerClassSingleton {



    private InnerClassSingleton() {
        if (InnerClassSingletonBuilder.innerClassSingleton != null) {
            throw new RuntimeException("不能初始化多个实例");
        }
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassSingletonBuilder.innerClassSingleton;
    }

    private static class InnerClassSingletonBuilder {
        protected final static  InnerClassSingleton innerClassSingleton = new InnerClassSingleton();
    }

    /**
     * 防止序列化破坏
     * @return
     */
    public Object readResolve() {
        return InnerClassSingletonBuilder.innerClassSingleton;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
    }

}
