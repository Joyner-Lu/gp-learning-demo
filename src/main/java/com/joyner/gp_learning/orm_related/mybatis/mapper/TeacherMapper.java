package com.joyner.gp_learning.orm_related.mybatis.mapper;

import com.joyner.gp_learning.orm_related.mybatis.entity.Teacher;
import com.sun.rowset.internal.Row;
import org.apache.ibatis.session.RowBounds;

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
public interface TeacherMapper {


    public int save(Teacher teacher);

    public Teacher selectById(int id);

    public List<Teacher> findAll(RowBounds rowBounds);

}
