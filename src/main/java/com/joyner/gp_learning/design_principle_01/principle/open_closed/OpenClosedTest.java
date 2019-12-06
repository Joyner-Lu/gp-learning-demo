package com.joyner.gp_learning.design_principle_01.principle.open_closed;

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
public class OpenClosedTest {

    public static void main(String[] args) {
        ICourse course = new JavaCourse(1, "Java体系课程", 23.33);
        ICourse javaDiscountCourse = new JavaDiscountCourse(1, "Java体系课程", 23.33);

        System.out.println(javaDiscountCourse.getPrice());
    }
}
