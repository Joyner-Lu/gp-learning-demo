package com.joyner.gp_learning.basic_jdbc_orm.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class Demo {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        //2.建立连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gp-vip-spring-db-demo", "root", "623582");
        System.out.println(connection);
        PreparedStatement preparedStatement = connection.prepareStatement("insert into test ( name) values ( 'jack')",
                                                                          Statement.RETURN_GENERATED_KEYS);
        boolean execute = preparedStatement.execute();
        System.out.println(execute);
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        while (resultSet.next()) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int generated_key = resultSet.getInt("GENERATED_KEY");
            System.out.println(generated_key);


        }
    }
}
