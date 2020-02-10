package com.joyner.gp_learning.design_pattern.observe.guava;

import com.google.common.eventbus.EventBus;

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
public class GuavaEventTest {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        /**
         * 总线注册订阅者
         */
        eventBus.register(new GuavaSubscriber());

        eventBus.post("发布");
    }
}
