package com.joyner.gp_learning.design_pattern.adapter.loginadapter.v2;

import com.joyner.gp_learning.design_pattern.adapter.loginadapter.ResultMsg;
import com.joyner.gp_learning.design_principle_01.principle.liskov_substitution.Rectangle;

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
public interface IPassportForThird {

    ResultMsg loginForQQ(String id);

    ResultMsg loginForWechat(String id);

    ResultMsg loginForToken(String id);

    ResultMsg loginForTel(String tel, String code);

    ResultMsg loginForRegister(String username, String pwd);
}
