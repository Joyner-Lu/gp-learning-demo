package com.joyner.gp_learning.orm_related.mybatis.test;

import com.alibaba.fastjson.JSONObject;
import com.joyner.gp_learning.orm_related.mybatis.entity.Student;
import com.joyner.gp_learning.orm_related.mybatis.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

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
public class TestTypeHandler {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-configs/main-config";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);

       /* Student student = new Student();
        student.setAddr("lily-addr");
        student.setAge(90);
        student.setName("lily");
        student.setTeacherId(1);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","jack2");
        jsonObject.put("title", "军师");
        student.setDocument(jsonObject);
        studentMapper.save(student);*/
        Student student = studentMapper.selectById(5);
        session.commit();
    }
}
