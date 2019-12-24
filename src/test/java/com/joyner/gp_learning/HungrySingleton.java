package com.joyner.gp_learning;

import java.io.ObjectInputStream;

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
public class HungrySingleton extends Object {

    private static final HungrySingleton hungrySingleton = new HungrySingleton();


    private HungrySingleton() {
        if (hungrySingleton != null) {
            //防止反射
            throw new RuntimeException("不能初始化多个实例");
        }
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    /**
     * 防止序列化破坏
     * @return
     */
    public Object readResolve() {
        return hungrySingleton;
    }
    public static void main(String[] args) {
        System.out.println(getInstance());
    }



}
