package com.joyner.gp_learning.jvm_related;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

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
public class VolatileDemo {

    volatile boolean running = true;

    void m() {
        System.out.println("m start.");
        while (running) {}
        System.out.println("m end.");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo demo = new VolatileDemo();
        new Thread(()->demo.m()).start();
        TimeUnit.SECONDS.sleep(1);
        demo.running = false;


    }
}
