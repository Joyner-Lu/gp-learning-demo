package com.joyner.gp_learning.zookeeper.my_distributed_lock.core.impl;

import com.joyner.gp_learning.zookeeper.my_distributed_lock.core.Lock;
import com.joyner.gp_learning.zookeeper.my_distributed_lock.core.LockWatch;
import com.joyner.gp_learning.zookeeper.my_distributed_lock.core.entity.LockInfo;
import com.joyner.gp_learning.zookeeper.my_distributed_lock.utils.ZookeeperFactory;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

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
public class DistributedLockZookeeperBased implements Lock {

    private ZooKeeper zk;
    private ThreadLocal<LockWatch> localLockWatch = new ThreadLocal<>();

    public DistributedLockZookeeperBased() {
        zk = ZookeeperFactory.getInstance().getZooKeeper();
    }


    @Override
    public void tryLock(String lock) {
        Thread t = Thread.currentThread();
        try {
            LockWatch lockWatch = localLockWatch.get();
            if (lockWatch == null) {
                lockWatch = initLocalLockWatch();
            }
            //获取锁状态
            int state = lockWatch.getLockState().get();
            if (state == 0) {
                //非重入锁
                System.out.println(Thread.currentThread().getName() + "进入获取锁逻辑, state:" + state + ",lockWatch hashCode:" + lockWatch.hashCode() + ",state hashCode:" + lockWatch.getLockState().hashCode());
                zk.create("/" + lock, t.getName().getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL, lockWatch, zk);

                CountDownLatch countDownLatch = lockWatch.getLockInfo().getCountDownLatch();
                countDownLatch.await();
            } else {
                int reEntryState = lockWatch.getLockState().incrementAndGet();
                System.out.println(Thread.currentThread().getName() + "重入锁,reEntryState:" + reEntryState + ",lockWatch hashCode:" + lockWatch.hashCode() + ",state hashCode:" + lockWatch.getLockState().hashCode());
            }
            //localLockState.get().get() > 0 重入锁，不需要在获取锁

            System.out.println(Thread.currentThread().getName() + "获取到了锁，state:" + lockWatch.getLockState().get() + ",lockWatch hashCode:" + lockWatch.hashCode() + ",state hashCode:" + lockWatch.getLockState().hashCode());


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private LockWatch initLocalLockWatch() {
        System.out.println(Thread.currentThread() + " initLocalLockWatch");
        LockWatch lockWatch = new LockWatch();
        LockInfo lockInfo = new LockInfo();
        lockInfo.setCountDownLatch(new CountDownLatch(1));
        lockWatch.setLockInfo(lockInfo);
        lockWatch.setZk(zk);
        localLockWatch.set(lockWatch);
        return lockWatch;
    }

    @Override
    public void unLock(String lock) {
        try {
            LockWatch lockWatch = localLockWatch.get();
            if (lockWatch == null) {
                lockWatch = initLocalLockWatch();
            }
            int state = lockWatch.getLockState().decrementAndGet();
            if (state == 0) {
                //释放锁
                LockInfo lockInfo = lockWatch.getLockInfo();
                System.out.println("threadName:" + Thread.currentThread().getName() + " 释放锁 " + lockInfo.getNodeName() + ",state:" + state +",lockWatch hashCode:"+ lockWatch.hashCode() + ",state hashCode:" + lockWatch.getLockState().hashCode());
                //解锁删除
                zk.delete(lockInfo.getNodeName(), -1);
            } else {
                System.out.println("threadName:" + Thread.currentThread().getName() + " 未解锁 state:" + state + ",lockWatch hashCode:" + lockWatch.hashCode() + ",state hashCode:" + lockWatch.getLockState().hashCode());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
