package com.joyner.gp_learning.basic_jdbc_orm.base;

import com.joyner.gp_learning.spring_related.dynamic_datasource.core.DynamicDataSource;

import javax.sql.DataSource;
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
public interface IBaseDao<T> {

    /**
     * 单表查询
     * @param condition
     * @return
     */
    public List<T> select(T condition);

    public void setDataSource(DataSource dataSource) ;

    public void setDynamicDataSource(DynamicDataSource dynamicDataSource);
}
