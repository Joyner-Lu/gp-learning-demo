package com.joyner.gp_learning.zookeeper.my_distributed_lock.utils;

import com.joyner.gp_learning.orm_related.mybatis.plugins.PhysicalRowBoundsInterceptor;
import com.joyner.gp_learning.zookeeper.my_distributed_lock.core.LockWatch;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import javax.management.relation.RoleUnresolved;
import java.util.concurrent.CountDownLatch;

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
public class ZookeeperFactory {

    private String addr = "localhost:2181/distributedLock";

    private ZookeeperFactory(){
    }

    private static ZookeeperFactory zookeeperFactory = new ZookeeperFactory();

    public static ZookeeperFactory getInstance() {
        return zookeeperFactory;
    }

    public ZooKeeper getZooKeeper() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zooKeeper = null;
        try {
            zooKeeper = new ZooKeeper(addr, 200, (event -> {
                Watcher.Event.KeeperState state = event.getState();
                switch (state) {
                    case Unknown:
                        break;
                    case Disconnected:
                        break;
                    case NoSyncConnected:
                        break;
                    case SyncConnected:
                        //连接成功返回
                        countDownLatch.countDown();
                        break;
                    case AuthFailed:
                        break;
                    case ConnectedReadOnly:
                        break;
                    case SaslAuthenticated:
                        break;
                    case Expired:
                        break;
                    case Closed:
                        break;
                }

            }));
            countDownLatch.await();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return zooKeeper;
    }

}
