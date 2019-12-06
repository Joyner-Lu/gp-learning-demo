package com.joyner.gp_learning.design_principle_01.principle.dependence_inversion;

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
public class JavaCourse implements ICourse {

    @Override
    public void study() {
        System.out.println("Tom 在学习Java课程");
    }
}
