package com.joyner.gp_learning.design_pattern.singleton.lazy;

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
public class LazySingletonWithSynchronized {

    private static LazySingletonWithSynchronized lazySingletonWithSynchronized = null;

    private LazySingletonWithSynchronized() {
        if (lazySingletonWithSynchronized != null) {
            throw new RuntimeException("不能重复创建实例");
        }
    }

    public static synchronized LazySingletonWithSynchronized getInstance() {
        if (lazySingletonWithSynchronized == null) {
            lazySingletonWithSynchronized = new LazySingletonWithSynchronized();
        }
        return lazySingletonWithSynchronized;
    }

    /**
     * 防止序列号
     * @return
     */
    public Object readResolve() {
        return lazySingletonWithSynchronized;
    }
}
