package com.joyner.gp_learning.design_pattern.adapter.loginadapter;

import com.joyner.gp_learning.design_pattern.adapter.loginadapter.ResultMsg;
import com.joyner.gp_learning.design_pattern.template.jdbc.Member;

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
public class SignInService {

    public ResultMsg register(String username, String pwd) {
        return new ResultMsg("200", "注册成功", new Member());
    }

    public ResultMsg login(String username, String pwd) {
        return new ResultMsg("200", "登录成功", new Member());
    }
}
