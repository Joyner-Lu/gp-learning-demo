package com.joyner.gp_learning.spring_related.spring_jdbc_demo;

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
public class TestSpringJdbc {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-jdbc/spring-jdbc.xml");
        MyDao bean = applicationContext.getBean(MyDao.class);
        bean.queryData();
    }
}
