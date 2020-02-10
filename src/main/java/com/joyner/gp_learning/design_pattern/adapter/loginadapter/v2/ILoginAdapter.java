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
public interface ILoginAdapter {

    /**
     * 是否这个适配器能够处理这个token
     * @param token
     * @return
     */
    public boolean supports(Object token);

    public ResultMsg login(String id, Object token);

}
