package com.joyner.gp_learning.design_pattern.adapter.loginadapter.v2;

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
public class PassportForThirdAdapter extends SignInService implements  IPassportForThird {
    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id,LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return processLogin(id,LoginForWechatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String id) {
        return processLogin(id,LoginForTokenAdapter.class);
    }

    @Override
    public ResultMsg loginForTel(String tel, String code) {
        return processLogin(tel,LoginForTelAdapter.class);
    }

    @Override
    public ResultMsg loginForRegister(String username, String pwd) {
        super.register(username, pwd);
        return super.login(username, pwd);
    }

    private ResultMsg processLogin(String key, Class<? extends ILoginAdapter> clz) {
        try {
            ILoginAdapter loginAdapter = clz.newInstance();
            if (loginAdapter.supports(loginAdapter)) {
                return loginAdapter.login(key, loginAdapter);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
