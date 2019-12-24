package com.joyner.gp_learning;

import static java.lang.Thread.sleep;

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

public class ThreadCommunication {

    public static void main(String[] args) {
        final ThreadCommunication obj = new ThreadCommunication();
        Thread t = new Thread("thread"){
            @Override
            public void run() {
                System.out.println(getName()+"方法suspend()运行开始");
                // synchronized (obj) {
                suspend();//挂起方法
                //}
                try {
                    sleep(1300);//让子线程在主线程执行resume方法之前没跑完
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName()+"方法suspend()运行完毕");
            }
        };
        t.start();
        System.out.println("沉睡1秒。。。");
        try {
            sleep(1000);//让子线程先运行
            System.out.println(t.getName() + "方法resume()运行开始");
            //synchronized (obj) {
            t.resume();//继续方法
            //}
            System.out.println(t.getName() + "方法resume()运行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

