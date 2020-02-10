package com.joyner.gp_learning.design_pattern.decorator.login.upgrade;

import com.joyner.gp_learning.design_pattern.decorator.login.old.ISignInService;
import com.joyner.gp_learning.design_pattern.decorator.login.old.ResultMsg;

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
public class SigninForThirdService implements ISignInForThirdService {

    private ISignInService signInService;

    public SigninForThirdService(ISignInService signInService) {
        this.signInService = signInService;
    }


    @Override
    public ResultMsg loginForQQ(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return null;
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return null;
    }

    @Override
    public ResultMsg loginForRegist(String username, String passport) {
        return null;
    }

    @Override
    public ResultMsg register(String username, String pwd) {
        return signInService.register(username, pwd);
    }

    @Override
    public ResultMsg login(String username, String pwd) {
        return signInService.login(username, pwd);
    }
}
