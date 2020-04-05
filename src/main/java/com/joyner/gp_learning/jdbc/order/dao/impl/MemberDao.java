package com.joyner.gp_learning.jdbc.order.dao.impl;

import com.joyner.gp_learning.jdbc.base.impl.BaseDao;
import com.joyner.gp_learning.jdbc.order.dao.IMemberDao;
import com.joyner.gp_learning.jdbc.order.entity.Member;

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
public class MemberDao extends BaseDao<Member> implements IMemberDao {

    @Override
    public List<Member> queryByName(String name) {
        Member condition = new Member();
        condition.setName(name);
        return select(condition);
    }
}
