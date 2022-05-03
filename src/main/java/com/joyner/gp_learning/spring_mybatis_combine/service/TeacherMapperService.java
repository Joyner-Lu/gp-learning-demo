package com.joyner.gp_learning.spring_mybatis_combine.service;

import com.github.pagehelper.PageHelper;
import com.joyner.gp_learning.orm_related.mybatis.entity.Teacher;
import com.joyner.gp_learning.orm_related.mybatis.mapper.TeacherMapper;
import lombok.Data;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

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
@Data
public class TeacherMapperService {

    @Autowired
    private TeacherMapper teacherMapper;

    public Teacher findById(int id) {
        Teacher teacher = teacherMapper.selectById(id);
        return teacher;
    }

    /**
     * 使用page-helper插件
     *
     * @param page
     * @param pageSize
     * @return
     */
    public List<Teacher> findByPage(int page, int pageSize) {
        //PageHelper.startPage(page, pageSize);
        int offset = pageSize * (page - 1);
        int limit = pageSize;
        RowBounds rowBounds = new RowBounds(offset, limit);
        List<Teacher> teacherList = teacherMapper.findAll(rowBounds);
        return teacherList;
    }
}
