package com.joyner.gp_learning.orm_related.mybatis.test;

import com.joyner.gp_learning.orm_related.mybatis.entity.Member;
import com.joyner.gp_learning.orm_related.mybatis.entity.Student;
import com.joyner.gp_learning.orm_related.mybatis.entity.Teacher;
import com.joyner.gp_learning.orm_related.mybatis.mapper.MemberMapper;
import com.joyner.gp_learning.orm_related.mybatis.mapper.StudentMapper;
import com.joyner.gp_learning.orm_related.mybatis.mapper.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
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
public class MemberTest {

    public static void main(String[] args) throws Exception {
        String resource = "mybatis-configs/main-config";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        /*MemberMapper memberMapper = session.getMapper(MemberMapper.class);
        Member member = memberMapper.selectById("1");
        System.out.println(member);

        List<Member> list = memberMapper.selectByName("tom");
        System.out.println(Arrays.toString(list.toArray()));*/
    /*    TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = new Teacher();
        teacher.setAge(22);
        teacher.setName("tom");
        int r = teacherMapper.save(teacher);
        System.out.println(r);*/

      /*  Student student = new Student();
        student.setAddr("lily-addr");
        student.setAge(90);
        student.setName("lily");
        student.setTeacherId(1);
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        studentMapper.save(student);*/
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.selectByName("jack");
        System.out.println(Arrays.toString(students.toArray()));
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.selectById(1);
        System.out.println(teacher);
        session.commit();
    }


}
