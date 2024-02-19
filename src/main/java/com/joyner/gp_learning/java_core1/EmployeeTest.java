package com.joyner.gp_learning.java_core1;

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
public class EmployeeTest {

    public static void main(String[] args) {
        Employee harry = new Employee("harry");
        Employee boos = new Employee("harry");
        System.out.println(harry.equalsV2(boos));

    }
}
