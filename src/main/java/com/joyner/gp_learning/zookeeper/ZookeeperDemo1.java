package com.joyner.gp_learning.zookeeper;

import com.joyner.gp_learning.zookeeper.my_distributed_lock.utils.ZookeeperFactory;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;
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
public class ZookeeperDemo1 {

    private ZooKeeper zooKeeper;

    public ZookeeperDemo1() throws Exception {
        zooKeeper = ZookeeperFactory.getInstance().getZooKeeper();


    }

    public static void main(String[] args) throws Exception {
        ZookeeperDemo1 zookeeperDemo1 = new ZookeeperDemo1();
        List<String> children = zookeeperDemo1.zooKeeper.getChildren("/", false);
        for (String c : children) {
            System.out.println("------" + c);
        }

    }

}
