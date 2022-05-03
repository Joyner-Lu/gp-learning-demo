package com.joyner.gp_learning.java_basic.future_demo;

import java.util.concurrent.Callable;

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
public class NettyCallableTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("执行耗时操作...");
        timeConsumingOperation();
        return 100;
    }


    void timeConsumingOperation() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
