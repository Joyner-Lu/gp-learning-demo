package com.joyner.gp_learning.netty_related.my_rpc_v2.service;

import com.joyner.gp_learning.netty_related.my_rpc_v2.entity.UserInfo;
import org.omg.PortableInterceptor.USER_EXCEPTION;

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
public class UserServiceImpl implements UserService {
    @Override
    public String deleteUser(String userId) {
        return "delete user:" + userId + " success.";
    }

    @Override
    public UserInfo findUser(String userId) {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(22);
        userInfo.setUserId(userId);
        userInfo.setUsername("test");
        return userInfo;
    }

    @Override
    public void updateUser(String userId) {
        System.out.println("------server---update-user success，userid:" + userId);
    }
}
