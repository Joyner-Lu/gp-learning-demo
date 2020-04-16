package com.joyner.gp_learning.basic_jdbc_orm.order.dao;

import com.joyner.gp_learning.basic_jdbc_orm.base.IBaseDao;
import com.joyner.gp_learning.basic_jdbc_orm.order.entity.Member;

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
public interface IMemberDao extends IBaseDao {

    public List<Member> queryByName(String name);

    public List<Member> queryAll();
}

