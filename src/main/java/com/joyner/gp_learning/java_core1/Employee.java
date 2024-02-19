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
public class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public boolean equalsV2(Employee e1) {
        return this.name.equals(e1.name);
    }
}
