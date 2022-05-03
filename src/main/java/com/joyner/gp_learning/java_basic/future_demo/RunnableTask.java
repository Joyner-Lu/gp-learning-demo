package com.joyner.gp_learning.java_basic.future_demo;

import javax.management.relation.RoleUnresolved;
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
public class RunnableTask implements Runnable {


    @Override
    public void run() {
        try {
            System.out.println("begin computation....");
            Thread.sleep(5000);
            System.out.println("finish computation....");

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}
