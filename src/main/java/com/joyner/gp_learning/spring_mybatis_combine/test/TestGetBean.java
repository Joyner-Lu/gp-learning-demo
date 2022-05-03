package com.joyner.gp_learning.spring_mybatis_combine.test;

import com.joyner.gp_learning.orm_related.mybatis.entity.Teacher;
import com.joyner.gp_learning.orm_related.mybatis.mapper.TeacherMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
public class TestGetBean {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis/spring-mybatis.xml");
        TeacherMapper bean = applicationContext.getBean(TeacherMapper.class);
        System.out.println(bean);
    }
}
