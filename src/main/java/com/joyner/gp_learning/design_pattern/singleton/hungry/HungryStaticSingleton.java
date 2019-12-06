package com.joyner.gp_learning.design_pattern.singleton.hungry;

import java.io.Serializable;

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
public class HungryStaticSingleton implements Serializable {

    private static final HungryStaticSingleton hungryStaticSingleton = new HungryStaticSingleton();

    private HungryStaticSingleton() {
        if (hungryStaticSingleton != null) {
            //防止反射
            throw new RuntimeException("不能重复构建实例");
        }
    }

    public static HungryStaticSingleton getInstance() {
        return hungryStaticSingleton;
    }

    /**
     * 防止序列号
     * @return
     */
    public Object readResolve() {
        return hungryStaticSingleton;
    }
}
