package com.joyner.gp_learning.design_pattern.adapter.loginadapter.v2;

import com.joyner.gp_learning.design_pattern.adapter.loginadapter.ResultMsg;

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
public class LoginForTokenAdapter implements ILoginAdapter {
    @Override
    public boolean supports(Object token) {
        return token instanceof LoginForTokenAdapter;
    }

    @Override
    public ResultMsg login(String id, Object token) {
        //处理登录
        return null;
    }
}
