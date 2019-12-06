package com.joyner.gp_learning.design_principle_01.principle.law_of_demeter;

import java.util.ArrayList;
import java.util.List;

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
public class TeamLeader {

    public void checkNumberOfCourse() {
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            courseList.add(new Course());
        }
        System.out.println("目前已经发布的课程数量是：" + courseList.size());

    }
}
