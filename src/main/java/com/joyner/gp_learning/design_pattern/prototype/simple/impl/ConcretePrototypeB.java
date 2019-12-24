package com.joyner.gp_learning.design_pattern.prototype.simple.impl;

import com.joyner.gp_learning.design_pattern.prototype.simple.Prototype;

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
public class ConcretePrototypeB implements Prototype {

    private int age;
    private String name;
    private List<String> hobbies;

    @Override
    public Prototype clone() {
        ConcretePrototypeB concretePrototypeB = new ConcretePrototypeB();
        concretePrototypeB.setAge(this.age);
        concretePrototypeB.setHobbies(this.hobbies);
        concretePrototypeB.setName(this.name);
        return concretePrototypeB;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
