package com.joyner.gp_learning.java_basic.socket.nio_version;

import org.apache.ibatis.annotations.SelectKey;

import java.net.InetSocketAddress;
import java.nio.channels.*;
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
public class SelectorThreadGroup {

    private int threadNum;
    private SelectorThread[] sts;
    private AtomicInteger xid = new AtomicInteger(-1);
    private SelectorThreadGroup stgWorker = this;//默认没有设置worker的时候，boss自己就是worker

    public SelectorThreadGroup(int threadNum, SelectorThreadGroup stgWorker) {
        String threadName = (stgWorker == null ? "woker-" : "boss-");
        SelectorThreadGroup tempStgWorker = (stgWorker == null ? this : stgWorker);
        this.threadNum = threadNum;
        sts = new SelectorThread[threadNum];
        for (int i = 0; i < sts.length; i++) {
            sts[i] = new SelectorThread(tempStgWorker);
            new Thread(sts[i], threadName + i).start();
        }
    }

    public SelectorThreadGroup(int threadNum) {
        this(threadNum, null);
    }

    /**
     * 绑定端口好
     * @param port
     */
    public void bind(int port) {
        try {
            ServerSocketChannel server = ServerSocketChannel.open();
            server.bind(new InetSocketAddress(port));
            server.configureBlocking(false);
            nextBossSelector(server);
            System.out.println("server is running. port:" + port);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public void nextBossSelector(Channel channel) throws Exception {
        SelectorThread selectorThread = nextBossSelectorThread();
        selectorThread.getQueue().add(channel);
        selectorThread.getSelector().wakeup();//唤醒
    }

    public void nextWorkerSelector(Channel channel) throws Exception {
        SelectorThread selectorThread = nextWorkerSelectorThread();
        selectorThread.getQueue().add(channel);
        selectorThread.getSelector().wakeup();//唤醒
    }
    private SelectorThread nextBossSelectorThread() {
        //轮询获取
        int temp = xid.incrementAndGet();
        if (temp == Integer.MAX_VALUE - 1) {
            xid.set(-1);//归位
        }
        int idx = temp % sts.length;
        return sts[idx];
    }

    private SelectorThread nextWorkerSelectorThread() {
        //轮询获取
        int temp = xid.incrementAndGet();
        if (temp == Integer.MAX_VALUE - 1) {
            xid.set(-1);//归位
        }
        int idx = temp % stgWorker.sts.length;
        return stgWorker.sts[idx];
    }

}
