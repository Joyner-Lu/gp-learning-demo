package com.joyner.gp_learning.design_pattern.factory;

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
public class PythonCourse implements ICourse {

    @Override
    public void record() {
        System.out.println("录制python视频");
    }
}
