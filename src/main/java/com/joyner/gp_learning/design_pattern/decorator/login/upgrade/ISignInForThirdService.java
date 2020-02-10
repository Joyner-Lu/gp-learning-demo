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

public interface ISignInForThirdService extends ISignInService {

    /*** QQ 登录 * @param id * @return */
    ResultMsg loginForQQ(String id);

    /*** 微信登录 * @param id * @return */
    ResultMsg loginForWechat(String id);

    /*** 记住登录状态后自动登录 * @param token * @return */
    ResultMsg loginForToken(String token);

    /*** 手机号登录 * @param telphone * @param code * @return */
    ResultMsg loginForTelphone(String telphone, String code);

    /*** 注册后自动登录 * @param username * @param passport * @return 11
     咕泡出品，必属精品 www.gupaoedu.com */
    ResultMsg loginForRegist(String username, String passport);

}


