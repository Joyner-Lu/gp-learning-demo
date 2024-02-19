package com.joyner.gp_learning.spring_related.spring_jdbc_demo;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;

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
public class MyDao  extends JdbcDaoSupport {

    public void queryData() throws Exception {
        /*getJdbcTemplate().query("select * from t_teacher", new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                String name = rs.getString("name");
                System.out.println("=======name:" + name);
                return null;
            }
        });*/

        PreparedStatementCreatorFactory factory = new PreparedStatementCreatorFactory("insert into test (name) values('fack')");
        PreparedStatementCreator creator = factory.newPreparedStatementCreator(new Object[] {});
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        getJdbcTemplate().update(creator, keyHolder);


    }

}
