package com.joyner.gp_learning.orm_related.mybatis.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Tom.
 */
@Data
public class Member implements Serializable {
    private Integer _id;
    private String name;
    private String addr;
    private Integer age;

}
