package com.joyner.gp_learning.design_pattern.delegate.simple;

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
public class EmployeeA implements  IEmployee{

    @Override
    public void doing(String command) {
        System.out.println("我是员工A，我现在开始干" + command + "工作");
    }
}
