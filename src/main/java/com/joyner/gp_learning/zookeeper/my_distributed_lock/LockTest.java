package com.joyner.gp_learning.zookeeper.my_distributed_lock;

import com.joyner.gp_learning.zookeeper.my_distributed_lock.core.impl.DistributedLockZookeeperBased;

import java.io.IOException;
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
public class LockTest {
   private static  String myLock = "myLock";
    public static void testReEnTry(DistributedLockZookeeperBased distributedLockZookeeperBased ) {
        distributedLockZookeeperBased.tryLock(myLock);
        System.out.println("----testReEnTry");
    }

    public static void main(String[] args) throws IOException {

        DistributedLockZookeeperBased distributedLockZookeeperBased = new DistributedLockZookeeperBased();
        new Thread(()->{
            System.out.println("线程 T1开始执行");
            distributedLockZookeeperBased.tryLock(myLock);
            try {
                System.out.println("===============线程 T1拿到锁开始执行");
                TimeUnit.SECONDS.sleep(5);
                testReEnTry(distributedLockZookeeperBased);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            distributedLockZookeeperBased.unLock(myLock);
        }, "线程 T1:").start();

      /*  new Thread(()->{
            System.out.println("线程 T2开始执行");
            distributedLockZookeeperBased.tryLock(myLock);
            System.out.println(Thread.currentThread().getName() + " 获取锁");
            try {
                System.out.println("=============线程 T2拿到锁开始执行");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            distributedLockZookeeperBased.unLock(myLock);

        }, "线程 T2:").start();
        System.in.read();*/
        System.in.read();
    }
}
