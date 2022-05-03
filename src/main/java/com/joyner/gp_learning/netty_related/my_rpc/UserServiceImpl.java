package com.joyner.gp_learning.netty_related.my_rpc;

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
}
