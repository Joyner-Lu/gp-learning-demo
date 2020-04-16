package com.joyner.gp_learning.orm_related.mybatis.factory;

import com.joyner.gp_learning.orm_related.mybatis.entity.Student;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

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
public class GPObjectFactory extends DefaultObjectFactory {

    @Override
    public <T> T create(Class<T> type) {
        if (type.equals(Student.class)) {
            Student student = (Student) super.create(type);
            student.setGenerateByFactory("by object factory");
            return (T)student;
        }
        T result = super.<T>create(type);
        return result;
    }

    public static void main(String[] args) {
        Student student = new GPObjectFactory().create(Student.class);
        System.out.println(student);
    }
}
