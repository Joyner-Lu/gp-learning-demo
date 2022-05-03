package com.joyner.gp_learning.orm_related.mybatis.test;

import com.joyner.gp_learning.orm_related.mybatis.entity.Student;
import com.joyner.gp_learning.orm_related.mybatis.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.List;

/**
 * <pre>
 *
 * 一级缓存，session级别的缓存，默认开启
 * 缓存是放在executor里面，基础的方式
 *
 *
 * 问题：不能夸session，会存在查询过时数据的问题
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
public class FirstCacheTest {


    @Test
    public void testCache01() throws Exception {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-configs/main-config"));
        SqlSession session = build.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> jack = mapper.selectByName("jack");


        //update会导致情况
        Student s = new Student();
        s.setId(1);
        s.setName("modify 111");
        mapper.updateNameById(s);
        session.commit();


        System.out.println("================");
        mapper.selectByName("jack");


        session.close();
    }
}
