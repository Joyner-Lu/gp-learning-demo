package com.joyner.gp_learning.design_pattern.factory.sample_factory;

import com.joyner.gp_learning.design_pattern.factory.ICourse;
import com.joyner.gp_learning.design_pattern.factory.JavaCourse;
import com.joyner.gp_learning.design_pattern.factory.PythonCourse;

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
public class CourseFactory implements ICourseFactory {

    @Override
    public ICourse create(Class<? extends ICourse> clz) {
        try {
            return (ICourse)clz.newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
