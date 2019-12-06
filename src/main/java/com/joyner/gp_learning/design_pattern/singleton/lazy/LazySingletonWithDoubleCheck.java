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
public class LazySingletonWithDoubleCheck {

    private static LazySingletonWithDoubleCheck lazySingletonWithDoubleCheck = null;

    private LazySingletonWithDoubleCheck() {
        if (lazySingletonWithDoubleCheck != null) {
            throw new RuntimeException("不能重复创建实例");
        }
    }

    public static LazySingletonWithDoubleCheck getInstance() {
        if (lazySingletonWithDoubleCheck == null) {
            synchronized (LazySingletonWithDoubleCheck.class) {
                if (lazySingletonWithDoubleCheck == null) {
                    lazySingletonWithDoubleCheck = new LazySingletonWithDoubleCheck();
                }
            }
        }
        return lazySingletonWithDoubleCheck;
    }

    /**
     * 防止序列号
     * @return
     */
    public Object readResolve() {
        return lazySingletonWithDoubleCheck;
    }
}
