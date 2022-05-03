package com.joyner.gp_learning.orm_related.mybatis.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

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
public class Student implements Serializable {

    private int id;
    private String name;
    private String addr;
    private int age;
    private int teacherId;
    private Teacher teacher;
    private StudentDocument studentDocument;
    private String generateByFactory;
}
