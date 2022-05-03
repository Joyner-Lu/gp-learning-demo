package com.joyner.gp_learning.spring_mybatis_combine.test;

import com.joyner.gp_learning.orm_related.mybatis.entity.Teacher;
import com.joyner.gp_learning.spring_mybatis_combine.service.TeacherMapperService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
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
public class SpringMybatisTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =  new ClassPathXmlApplicationContext("spring-mybatis/spring-mybatis.xml");
        TeacherMapperService teacherMapperService = (TeacherMapperService)applicationContext.getBean("teacherMapperService");
        List<Teacher> list = teacherMapperService.findByPage(2, 4);
        System.out.println(Arrays.toString(list.toArray()));
        //System.out.println(teacherMapperService.findById(1));
    }
}
