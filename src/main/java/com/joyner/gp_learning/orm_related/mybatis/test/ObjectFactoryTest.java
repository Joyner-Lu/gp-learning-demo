package com.joyner.gp_learning.orm_related.mybatis.test;

import com.joyner.gp_learning.orm_related.mybatis.entity.Student;
import com.joyner.gp_learning.orm_related.mybatis.factory.GPObjectFactory;
import com.joyner.gp_learning.orm_related.mybatis.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

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
public class ObjectFactoryTest {

    @Test
    public void testDemo1() {
        GPObjectFactory gpObjectFactory = new GPObjectFactory();
        Student student = gpObjectFactory.create(Student.class);
        System.out.println(student);
    }

    @Test
    public void testQueryStudent() throws Exception {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-configs/main-config"));
        SqlSession session = build.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.selectById(4);
        System.out.println(student);

        session.close();
    }

}
