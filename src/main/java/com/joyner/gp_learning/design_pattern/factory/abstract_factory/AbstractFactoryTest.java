package com.joyner.gp_learning.design_pattern.factory.abstract_factory;

import java.util.Arrays;

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
public class AbstractFactoryTest {

    public static void main(String[] args) {
        ICourseFactory courseFactory = new JavaCourseFactory();
        INode node = courseFactory.createNode();
        IVideo video = courseFactory.createVideo();
        node.edit();
        video.record();
    }
}
