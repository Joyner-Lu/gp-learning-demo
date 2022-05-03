package com.joyner.gp_learning.orm_related.mybatis.test;

import com.joyner.gp_learning.orm_related.mybatis.entity.Student;
import com.joyner.gp_learning.orm_related.mybatis.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

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
public class TestRowBounds {

    @Test
    public void testRowBounds() throws Exception {
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-configs/main-config"));
        SqlSession session = build.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        int start = 2;//offset,会舍弃前面 offset条数据
        int pageSize = 2;//limit
        RowBounds rowBounds = new RowBounds(start, pageSize);


        List<Student> jack = mapper.selectByName("jack", rowBounds);
        for (Student stu : jack) {
            System.out.println(stu);
        }

        session.close();
    }
}
