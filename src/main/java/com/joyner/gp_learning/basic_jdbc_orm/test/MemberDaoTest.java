package com.joyner.gp_learning.basic_jdbc_orm.test;

import com.joyner.gp_learning.basic_jdbc_orm.order.dao.IMemberDao;
import com.joyner.gp_learning.basic_jdbc_orm.order.dao.impl.MemberDao;
import com.joyner.gp_learning.basic_jdbc_orm.order.entity.Member;

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
public class MemberDaoTest {

    public static void main(String[] args) {
        IMemberDao memberDao = new MemberDao();
        List<Member> members = memberDao.queryByName("tom33");
        System.out.println(Arrays.toString(members.toArray()));
    }
}
