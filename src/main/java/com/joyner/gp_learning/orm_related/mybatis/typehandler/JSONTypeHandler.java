package com.joyner.gp_learning.orm_related.mybatis.typehandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.joyner.gp_learning.orm_related.mybatis.entity.StudentDocument;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.lang.reflect.Type;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <pre>
 *  分析：
 *  （1）写法1
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
public class JSONTypeHandler extends BaseTypeHandler {
    public JSONTypeHandler() {

    }


    /**
     * 设置数据库的字段
     * @param ps
     * @param i
     * @param parameter
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        String jsonStr = JSON.toJSONString(parameter);
        ps.setString(i, jsonStr);
    }


    /**
     * 解析
     * @param rs
     * @param columnName
     * @return
     * @throws SQLException
     */
    @Override
    public StudentDocument getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String jsonStr = rs.getString(columnName);
        StudentDocument studentDocument = JSONObject.parseObject(jsonStr,StudentDocument.class);
        return studentDocument;
    }

    @Override
    public StudentDocument getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String jsonStr = rs.getString(columnIndex);

        StudentDocument studentDocument = JSONObject.parseObject(jsonStr,StudentDocument.class);
        return studentDocument;
    }


    @Override
    public StudentDocument getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String jsonStr = cs.getString(columnIndex);
        StudentDocument studentDocument = JSONObject.parseObject(jsonStr,StudentDocument.class);
        return studentDocument;
    }
}
