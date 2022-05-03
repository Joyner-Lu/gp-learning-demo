package com.joyner.gp_learning.java_basic.thread_concurrence;

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
public class VolatileTest {

    boolean isRunning = true;

    public void start() {
        System.out.println("server start.");
        while (isRunning) {

        }
        System.out.println("server end.");
    }

    public static void main(String[] args) throws Exception {
        VolatileTest volatileTest = new VolatileTest();
        new Thread(volatileTest::start).start();
        Thread.sleep(1000);
        volatileTest.isRunning = false;
    }


}
