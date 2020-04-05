package com.joyner.gp_learning.basic_jdbc_orm.order.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Tom.
 */
@Entity
@Table(name="t_member")
@Data
public class Member implements Serializable {
    @Id private Integer id;
    private String name;
    @Column(name = "addr")
    private String addr;
    private Integer age;


}
