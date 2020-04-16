package com.joyner.gp_learning.basic_jdbc_orm.base.impl;

import com.joyner.gp_learning.basic_jdbc_orm.base.IBaseDao;
import com.joyner.gp_learning.basic_jdbc_orm.order.entity.Member;
import com.joyner.gp_learning.spring_related.dynamic_datasource.core.DynamicDataSource;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.sql.DataSource;

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
public class BaseDao<T> implements IBaseDao {

    private String tableName;
    //列名和字段名的映射，键是数据库列名称，值是实体的属性名
    private Map<String, Field> columnMapping = new HashMap<>();
    //条件map,key存储数据库列名称，值存储值
    private Map<String, Object> conditionMapping = new HashMap<>();
    private List<String> allColumn = new ArrayList<>();
    private DataSource dataSource;
    private DynamicDataSource dynamicDataSource;

    public void setDynamicDataSource(DynamicDataSource dynamicDataSource) {
        this.dynamicDataSource = dynamicDataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<T> select(Object condition) {

        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        List<T> result = new ArrayList<>();
        try {
            
            parseTableName(condition);
            parseFieldNameMapping(condition);
            connection = getConnection();
            //1.加载驱动类
            //2.建立连接
            //3.创建语句集
            String sql = "select * from " + tableName;
            sql = appendCondition(sql, condition);
            System.out.println("SQL:[" + sql + "]");
            preparedStatement = connection.prepareStatement(sql);
            //4.执行语句集
            resultSet = preparedStatement.executeQuery();
            parseColumnMapping(condition, resultSet);
            parseAllColumn(resultSet);
            //5.获取结果集并处理
            while (resultSet.next()) {
                Class<T> clz = (Class<T>)condition.getClass();
                T entity = clz.newInstance();
                for (String columnName : allColumn) {
                    Object value = resultSet.getObject(columnName);
                    Field entityFiled = columnMapping.get(columnName);
                    if (entityFiled != null) {
                        entityFiled.setAccessible(true);
                        entityFiled.set(entity, value);
                    }

                }
                result.add(entity);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            //6.关闭结果集、语句集、关闭连接
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        return result;
    }



    private Connection getConnection() throws Exception{
        Connection connection = null;
        if (dynamicDataSource != null) {
            return dynamicDataSource.getConnection();
        }

        if( dataSource != null) {
            connection = dataSource.getConnection();
            return connection;
        }
        Class.forName("com.mysql.jdbc.Driver");
        //2.建立连接
        connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gp-vip-spring-db-demo","root", "623582");
        return connection;

    }

    private void parseFieldNameMapping(Object condition) throws Exception {
        Field[] fields = condition.getClass().getDeclaredFields();
        for (Field field : fields) {
            String columnName = field.getName();
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                if (!StringUtils.isEmpty(column.name())) {
                    columnName = column.name();
                }
            }
            field.setAccessible(true);
            Object value = field.get(condition);
            if (value != null) {
                conditionMapping.put(columnName, value);
            }
        }
    }

    private String appendCondition(String sql, Object condition) {
        StringBuilder sqlBuilder = new StringBuilder(sql + " where 1 = 1 ");
        if (conditionMapping.size() > 0) {
            Set<Map.Entry<String, Object>> set = conditionMapping.entrySet();
            for (Map.Entry<String, Object> entry : set) {
                String columnName = entry.getKey();
                Object conditionVal = entry.getValue();
                if (conditionVal instanceof String) {
                    sqlBuilder.append(" and " + columnName + " = '" + conditionVal.toString() + "'");
                } else {
                    sqlBuilder.append(" and " + columnName + " = " + conditionVal.toString());
                }
            }
        }
        return sqlBuilder.toString();
    }

    private void parseAllColumn(ResultSet resultSet) throws Exception {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 0; i < columnCount ; i++) {
            String columnName = metaData.getColumnName(i+1);
            allColumn.add(columnName);
        }
    }

    private void parseTableName(Object condition) {
        Class entityClz = condition.getClass();
        tableName = entityClz.getSimpleName().toLowerCase();
        if(entityClz.isAnnotationPresent(Table.class)) {
            Table table = (Table)entityClz.getAnnotation(Table.class);
            tableName = table.name();
        }
    }

    private void parseColumnMapping(Object condition, ResultSet resultSet) {
        Class entityClz = condition.getClass();
        Field[] fields = entityClz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = (Column)field.getAnnotation(Column.class);
                String columnName = field.getName();
                if (!StringUtils.isEmpty(column.name())) {
                    columnName = column.name();
                }
                columnMapping.put(columnName, field);
            } else {
                columnMapping.put(field.getName(), field);
            }
        }

    }

    public static void main(String[] args) throws Exception{
        //Class.forName("com.mysql.jdbc.Driver");
        //2.建立连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gp-vip-spring-db-demo","root", "623582");
        System.out.println(connection);
    }
}
