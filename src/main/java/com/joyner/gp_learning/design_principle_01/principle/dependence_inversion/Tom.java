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
public class Tom {

    private ICourse course;

    public Tom() {}

    /**
     * 构造器注入
     * @param course
     */
    public Tom(ICourse course) {
        this.course = course;
    }

    /**
     * setter注入
     * @param course
     */
    public void setCourse(ICourse course) {
        this.course = course;
    }

    /*public void studyJavaCourse() {
        System.out.println("Tom 在学习Java课程");
    }

    public void studyPythonCourse() {
        System.out.println("Tom 在学习Python课程");
    }*/

    public void study(ICourse course) {
        course.study();
    }

    public void study() {
        this.course.study();
    }
}
