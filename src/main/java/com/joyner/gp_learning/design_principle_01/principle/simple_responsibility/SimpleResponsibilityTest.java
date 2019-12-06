package com.joyner.gp_learning.design_principle_01.principle.simple_responsibility;

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
public class SimpleResponsibilityTest {

    public static void main(String[] args) {
        Course course = new Course();
        course.study("直播课");

        LiveCourse course1 = new LiveCourse();
        course1.study("直播课");

        ReplayCourse replayCourse = new ReplayCourse();
        replayCourse.study("回放课程");
    }
}
