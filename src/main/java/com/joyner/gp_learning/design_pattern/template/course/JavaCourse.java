package com.joyner.gp_learning.design_pattern.template.course;

import java.util.AbstractList;

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
public class JavaCourse extends NetWorkCourse {


    @Override
    protected void checkHomework() {
        System.out.println("检查java作业");
    }
}
