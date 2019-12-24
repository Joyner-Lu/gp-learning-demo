package com.joyner.gp_learning.design_pattern.prototype.simple;

import com.joyner.gp_learning.design_pattern.prototype.simple.impl.ConcretePrototypeA;

import java.util.ArrayList;
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
public class PrototypeTest {

    public static void main(String[] args) {
        ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
        concretePrototypeA.setAge(22);
        concretePrototypeA.setName("AA");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("hobby one");
        concretePrototypeA.setHobbies(hobbies);

        Client client = new Client();
        ConcretePrototypeA prototype = (ConcretePrototypeA)client.startClone(concretePrototypeA);

        System.out.println(prototype.getHobbies() == concretePrototypeA.getHobbies());
        concretePrototypeA.setAge(333);
        hobbies.add("hobby two");
        System.out.println(prototype.getHobbies() + "--" + concretePrototypeA.getHobbies());
    }
}
