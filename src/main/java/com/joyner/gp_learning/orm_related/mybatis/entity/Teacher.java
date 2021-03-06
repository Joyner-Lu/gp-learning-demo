package com.joyner.gp_learning.orm_related.mybatis.entity;

import lombok.Data;

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
public class Teacher {
    private int id;
    private String name;
    private int age;
    private List<Student> students;
}
