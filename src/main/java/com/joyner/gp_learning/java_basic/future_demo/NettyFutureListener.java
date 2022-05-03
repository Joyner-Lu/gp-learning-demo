package com.joyner.gp_learning.java_basic.future_demo;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;

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
public class NettyFutureListener implements FutureListener<Object> {

    private Future<Integer> f;

    public NettyFutureListener(Future<Integer> f) {
        this.f = f;
    }

    @Override
    public void operationComplete(Future<Object> future) throws Exception {
        System.out.println("计算结果:：" + f.get());

    }
}
