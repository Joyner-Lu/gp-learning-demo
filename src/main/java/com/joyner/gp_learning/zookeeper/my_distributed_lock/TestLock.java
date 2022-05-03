package com.joyner.gp_learning.zookeeper.my_distributed_lock;

import com.joyner.gp_learning.zookeeper.my_distributed_lock.core.Lock;
import com.joyner.gp_learning.zookeeper.my_distributed_lock.core.impl.DistributedLockZookeeperBased;

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
public class TestLock {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                String lockStr = "lock1";
                Lock lock = new DistributedLockZookeeperBased();
                lock.tryLock(lockStr);

                System.out.println("working");
               /* try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                lock.unLock(lockStr);

            }).start();

        }
        while (true);
    }
}
