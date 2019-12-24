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
public class LazySingleton {

    public static volatile LazySingleton lazySingleton = null;

    private LazySingleton() {
        if (lazySingleton != null) {
            throw new RuntimeException("不能初始化多个实例");
        }
    }

    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            synchronized (LazySingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    /**
     * 防止序列化破坏
     * @return
     */
    public Object readResolve() {
        return lazySingleton;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
    }

}
