package com.joyner.gp_learning.jvm_related.exception_code;

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
public class ExceptionTest {
    public static void main(String[] args) {
        new ExceptionTest().sayHello('A');
    }

 /*   public void sayHello(char c) {
        System.out.println("hello char");
    }*/
    public void sayHello(int c) {
        System.out.println("hello int");
    }

    public void sayHello(long c) {
        System.out.println("hello char");
    }
}


