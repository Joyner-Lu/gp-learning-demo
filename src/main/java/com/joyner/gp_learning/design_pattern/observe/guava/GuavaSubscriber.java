package com.joyner.gp_learning.design_pattern.observe.guava;

import com.google.common.eventbus.Subscribe;

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
public class GuavaSubscriber {

    /**
     * Subscribe也就是订阅总线发布的消息
     * @param msg
     */
    @Subscribe
    public void subscribe(String msg) {
        System.out.println(msg);
    }
}
