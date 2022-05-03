package com.joyner.gp_learning.netty_related.my_rpc_v2.service;

import com.joyner.gp_learning.netty_related.my_rpc_v2.entity.UserInfo;

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
public interface UserService {

    public String deleteUser(String userId);

    public UserInfo findUser(String userId);

    public void updateUser(String userId);

}
