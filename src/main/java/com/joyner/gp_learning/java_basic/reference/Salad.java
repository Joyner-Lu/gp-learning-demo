package com.joyner.gp_learning.java_basic.reference;

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

import java.lang.ref.WeakReference;

/**
 * Salad class
 * 继承WeakReference，将Apple作为弱引用。
 * 注意到时候回收的是Apple，而不是Salad
 *
 * @author BrightLoong
 * @date 2018/5/25
 */
public class Salad extends WeakReference<Apple> {
    public Salad(Apple apple) {
        super(apple);
    }
}
