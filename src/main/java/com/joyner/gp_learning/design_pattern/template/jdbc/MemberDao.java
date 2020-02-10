package com.joyner.gp_learning.design_pattern.template.jdbc;

import javax.sql.DataSource;
import java.sql.ResultSet;
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
public class MemberDao extends JDBCTemplate<Member> {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<Member> findAll() {
        String sql = "select * from t_member";
        List<Member> result = super.executeQuery(sql, null, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) {
                try {
                    Member member = new Member();
                    //这里如果字段过多的话，可以使用原型模式。也就是以ResultSet为原型，拷贝出Member来。
                    member.setUsername(rs.getString("username"));
                    member.setAddr(rs.getString("addr"));
                    member.setAge(rs.getInt("age"));
                    member.setPassword(rs.getString("pwd"));
                    return member;
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        return result;
    }
}
