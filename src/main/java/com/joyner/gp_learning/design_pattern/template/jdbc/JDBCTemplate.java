package com.joyner.gp_learning.design_pattern.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public abstract class JDBCTemplate<T> {

    private DataSource dataSource;

    public JDBCTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<T> executeQuery(String sql, Object[] args, RowMapper<T> rowMapper) {
        try {
            //1.获取连接
            Connection conn = this.getConn();
            //2.创建语句集
            PreparedStatement pstm = this.createPreparedStatement(conn, sql);
            //3.执行语句集
            ResultSet rs = this.executeQuery(pstm, args);
            //4.处理结果集
            List<T> result = this.parseResultSet(rs, rowMapper);
            //5.关闭结果集
            this.closeRs(rs);
            //6.关闭语句集
            this.closeStatement(pstm);
            //7.关闭连接
            this.closeConnection(conn);
            return  result;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private ResultSet executeQuery(PreparedStatement pstm, Object[] args) throws SQLException {
        //设置参数
        for (int i = 0; i < args.length; i++) {
            int idx = i++;
            pstm.setObject(idx, args[i]);
        }
        //执行语句
        ResultSet rs = pstm.executeQuery();
        return rs;
    }

    private void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }

    private void closeStatement(PreparedStatement pstm) throws SQLException {
        pstm.close();
    }

    private void closeRs(ResultSet rs) throws SQLException {
        rs.close();
    }

    private List<T> parseResultSet(ResultSet rs, RowMapper<T> rowMapper) throws SQLException {
        List<T> result = new ArrayList<>();
        int rowNum = 0;
        while (rs.next()) {
            rowNum++;
            T rowVal = rowMapper.mapRow(rs, rowNum);
            result.add(rowVal);
        }
        return result;
    }

    private PreparedStatement createPreparedStatement(Connection conn, String sql) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        return preparedStatement;
    }

    private Connection getConn() throws SQLException {
        return dataSource.getConnection();
    }

}
