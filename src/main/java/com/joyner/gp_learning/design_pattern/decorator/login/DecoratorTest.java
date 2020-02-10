package com.joyner.gp_learning.design_pattern.decorator.login;


import com.joyner.gp_learning.design_pattern.decorator.login.old.SignInService;
import com.joyner.gp_learning.design_pattern.decorator.login.upgrade.ISignInForThirdService;
import com.joyner.gp_learning.design_pattern.decorator.login.upgrade.SigninForThirdService;

import javax.swing.*;

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
public class DecoratorTest {

    public static void main(String[] args) {
        ISignInForThirdService signinForThirdService = new SigninForThirdService(new SignInService());
        signinForThirdService.loginForQQ("xdcdfswrwsdfssdfqsdf"); //为某个类实现动态增加或者覆盖原有方法的情况，采用装饰器模式 }
    }


}
