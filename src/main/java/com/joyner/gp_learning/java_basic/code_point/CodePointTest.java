package com.joyner.gp_learning.java_basic.code_point;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class CodePointTest {

    public static void main(String[] args) {
        String s1 = "\uD835\uDD46";
        System.out.println(s1);
        int i = s1.codePointAt(0);
        System.out.println(i);
    }
}