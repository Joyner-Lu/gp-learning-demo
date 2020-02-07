package com.joyner.gp_learning.design_pattern.proxy.static_proxy;

import com.joyner.gp_learning.design_pattern.proxy.Person;

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
public class Son implements Person {
    @Override
    public void findLove() {
        System.out.println("儿子要求：肤白貌美大长腿");
    }

    @Override
    public String test001(String param) {
        System.out.println("test Son");
        return "ok-son";
    }
}
