package com.joyner.gp_learning.orm_related.mybatis.test;

import com.joyner.gp_learning.orm_related.mybatis.entity.Student;
import com.joyner.gp_learning.orm_related.mybatis.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * <pre>
 *  使用装饰器
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
public class SecondCacheTest {

    @Test
    public void test01() throws Exception {

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-configs/main-config"));
        SqlSession session1 = build.openSession();

        StudentMapper mapper = session1.getMapper(StudentMapper.class);
        mapper.selectByName("jack");


        session1.commit();//事务不提交，二级缓存不会写入
        System.out.println("=============");
        SqlSession session2 = build.openSession();
        StudentMapper mapper1 = session2.getMapper(StudentMapper.class);
        mapper1.selectByName("jack");


        session1.close();
        session2.close();

    }
}
