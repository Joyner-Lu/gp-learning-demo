package com.joyner.gp_learning.zookeeper.my_distributed_lock.core;

import com.joyner.gp_learning.zookeeper.my_distributed_lock.core.entity.LockInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqingyun@foresee.cn
 * @version 1.00.00
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */

public class LockWatch implements Watcher, AsyncCallback.StatCallback, AsyncCallback.StringCallback, AsyncCallback.ChildrenCallback {

    private ZooKeeper zk;
    private LockInfo lockInfo;
    private AtomicInteger lockState = new AtomicInteger(0);

    public LockWatch() {
      /*  lockState.set(1);
        System.out.println(Thread.currentThread().getName() + "构建 LockWatch(), state:" + lockState.get() + ",lockWatch hashCode:" + this.hashCode() + ",state hashCode:" + lockState.hashCode());*/
    }

    public ZooKeeper getZk() {
        return zk;
    }

    public LockInfo getLockInfo() {
        return lockInfo;
    }

    public AtomicInteger getLockState() {
        return lockState;
    }


    public void setLockInfo(LockInfo lockInfo) {
        this.lockInfo = lockInfo;
    }

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }


    @Override
    public void process(WatchedEvent event) {
        Event.EventType type = event.getType();
        switch (type) {
            case None:
                break;
            case NodeCreated:
                break;
            case NodeDeleted:
                //前面一个节点删除了，证明我有机会获得锁
                zk.getChildren("/", false, this, zk);
                System.out.println("delete,t:" + Thread.currentThread().getName() + ",node:" + event.getPath() + ",lockWatch hashCode:" + this.hashCode() + ",state hashCode:" + lockState.hashCode());
                break;
            case NodeDataChanged:
                break;
            case NodeChildrenChanged:
                break;
            case DataWatchRemoved:
                break;
            case ChildWatchRemoved:
                break;
            case PersistentWatchRemoved:
                break;
        }


    }

    /**
     * 处理节点是否存在回调
     * @param rc
     * @param path
     * @param ctx
     * @param stat
     */
    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {
        if (stat == null) {
            //不存在，重新获取子节点
            zk.getChildren("/", false, this, zk);
        }


    }

    /**
     * 创建回调
     * @param rc
     * @param path
     * @param ctx
     * @param name
     */
    @Override
    public void processResult(int rc, String path, Object ctx, String name) {
        try {
            ZooKeeper zk = (ZooKeeper) ctx;
            if (StringUtils.isNotEmpty(name)) {
                zk.getChildren("/", false, this, zk);
                lockInfo.setNodeName(name);
                System.out.println("threadname:" + Thread.currentThread().getName() +",nodename:" + name + ",lockWatch hashCode:" + this.hashCode() + ",state hashCode:" + lockState.hashCode());
            }


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    /**
     * get children 回调
     * @param rc
     * @param path
     * @param ctx
     * @param children
     */
    @Override
    public void processResult(int rc, String path, Object ctx, List<String> children) {
        ZooKeeper zk = (ZooKeeper) ctx;
        //获取孩子节点
        Collections.sort(children);
        int idx = children.indexOf(lockInfo.getNodeName().substring(1));
        if (idx == 0) {
            //获取到了锁，需要加1
            int state = lockState.incrementAndGet();
            //获取到了锁
            lockInfo.getCountDownLatch().countDown();
            System.out.println("线程：" + Thread.currentThread().getName() + " 获取到了锁,nodeName:" + lockInfo.getNodeName() + ",state:" + state + ",lockWatch hashCode:" + this.hashCode() + ",state hashCode:" + lockState.hashCode());
            //System.out.println("threadname:" + Thread.currentThread().getName() + " i am the first. nodename:" + this.nodeName);

        } else {
            String preNodePath = children.get(idx -1);
            zk.exists("/" + preNodePath, this, this, zk);
        }

    }
}
