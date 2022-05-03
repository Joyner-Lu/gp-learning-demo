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
public class Parent {

    private static final String lock = "test";


    private Integer i = new Integer(3);
    private String s = new String();

    private int m  = 3;

    public Parent() {
        m = 5;
    }

    public void set() {
        synchronized (lock) {

        }

        m = 8;
    }

    public static void main(String[] args) {
        Parent p = new Parent();
        p.set();
    }
}
