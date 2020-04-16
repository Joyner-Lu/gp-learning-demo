package com.joyner.gp_learning.spring_related.dynamic_datasource.test;

import com.joyner.gp_learning.basic_jdbc_orm.order.dao.IMemberDao;
import com.joyner.gp_learning.basic_jdbc_orm.order.dao.impl.MemberDao;
import com.joyner.gp_learning.basic_jdbc_orm.order.entity.Member;
import com.joyner.gp_learning.spring_related.dynamic_datasource.core.DynamicDataSource;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.Arrays;
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
public class DynamicDataSourceTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-dynamic-db.xml");
        DataSource dataSource2018 = (DataSource)context.getBean("dataSource2018");
        DataSource dataSource2019 = (DataSource)context.getBean("dataSource");
        DynamicDataSource dynamicDataSource = (DynamicDataSource)context.getBean("dynamicDataSource");
        dynamicDataSource.getDataSourceEntry().set("DB_2019");
        testDynamicDataSource(dynamicDataSource);


    }

    public static void testDynamicDataSource(DynamicDataSource dynamicDataSource) {
        IMemberDao memberDao = new MemberDao();
        memberDao.setDynamicDataSource(dynamicDataSource);
        List<Member> list = memberDao.queryAll();
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void testIndivid(DataSource dataSource2018, DataSource dataSource2019 ) {
        IMemberDao memberDao = new MemberDao();
        memberDao.setDataSource(dataSource2018);
        List<Member> list = memberDao.queryAll();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("----------------");
        memberDao.setDataSource(dataSource2019);
        list = memberDao.queryAll();
        System.out.println(Arrays.toString(list.toArray()));
    }

}
