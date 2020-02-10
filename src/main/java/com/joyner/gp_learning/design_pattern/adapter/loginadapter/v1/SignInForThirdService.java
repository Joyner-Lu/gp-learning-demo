package com.joyner.gp_learning.design_pattern.adapter.loginadapter.v1;

import com.joyner.gp_learning.design_pattern.adapter.loginadapter.ResultMsg;
import com.joyner.gp_learning.design_pattern.adapter.loginadapter.SignInService;

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
public class SignInForThirdService extends SignInService {

    public ResultMsg loginForQQ(String openId) {
        //1.openId是全局唯一，可以当做用户名
        //2.给一个默认的密码QQ_EMPTY
        String qqDefaultPwd = "QQ_PWD_EMPTY";
        //3.注册（在原有系统创建一个用户）

        //4.调用登录方法
        return this.loginForRegist(openId, qqDefaultPwd);
    }

    public ResultMsg loginForWechat(String openId) {
        String qqDefaultPwd = "Wechat_PWD_EMPTY";
        return this.loginForRegist(openId, qqDefaultPwd);

    }

    public ResultMsg loginForToken(String token) {
        //通过 token 拿到用户信息，然后再重新登陆了一次

        return null;
    }

    public ResultMsg loginForTelephone(String phone, String code) {

        return null;
    }

    private ResultMsg loginForRegist(String username, String pwd) {
        super.register(username, pwd);
        return super.login(username, pwd);
    }


}
