package com.joyner.gp_learning.design_pattern.singleton.hungry;

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
public class LazySingletonWithInnerClass {


    private LazySingletonWithInnerClass() {
        if (LazySingletonHolder.lazySingletonWithInnerClass != null) {
            throw new RuntimeException("不能重复创建实例");
        }
    }

    public static LazySingletonWithInnerClass getInstance() {
        return LazySingletonHolder.lazySingletonWithInnerClass;
    }

    /**
     * 防止序列号
     * @return
     */
    public Object readResolve() {
        return LazySingletonHolder.lazySingletonWithInnerClass;
    }

    private static class LazySingletonHolder {
        private final static LazySingletonWithInnerClass lazySingletonWithInnerClass = new LazySingletonWithInnerClass();
    }
}
