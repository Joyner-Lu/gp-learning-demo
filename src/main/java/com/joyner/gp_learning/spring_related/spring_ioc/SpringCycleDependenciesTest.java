package com.joyner.gp_learning.spring_related.spring_ioc;

import com.joyner.gp_learning.spring_related.spring_bean_lifecycle.Car;
import com.joyner.gp_learning.spring_related.spring_bean_lifecycle.CycleA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
public class SpringCycleDependenciesTest {
    private static void applicationTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-life-cycle.xml");
        CycleA cycleA = (CycleA)applicationContext.getBean("cycleA");
        System.out.println(cycleA.getCycleB());
    }

    public static void main(String[] args) {
        applicationTest();
    }
}
