package com.joyner.gp_learning.netty_related.my_nio;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class LuNioEngine {

    /**
     * worker数组
     */
    static BlockingQueue<SocketChannel>[] queues;

    static AtomicInteger idx = new AtomicInteger(0);

    private Selector[] selectors;

    static int workerCount = 0;
    private int port = 9090;
    private int totalNum;


    public void start(int workerCount) throws Exception {
        assert workerCount > 0;
        this.workerCount = workerCount;
        queues = new BlockingQueue[workerCount];
        for (int i = 0; i < workerCount; i++) {
            queues[i] = new LinkedBlockingDeque<>();
        }
        totalNum = workerCount + 1;
        selectors = new Selector[totalNum];//boss占用一个
        for (int i = 0; i < totalNum; i++) {
            selectors[i] = Selector.open();
        }
        //监听9090端口
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(port));
        server.configureBlocking(false);
        server.register(selectors[0], SelectionKey.OP_ACCEPT);
        System.out.println("服务器启动了。。。。。" + port);

        //初始化boss
        NioThread boss = new NioThread(selectors[0], Integer.MAX_VALUE, true);
        boss.start();
        //初始化worker
        for (int i = 0; i < workerCount; i++) {
            //0被boss占用
            NioThread worker = new NioThread(selectors[i + 1], i, false);
            worker.start();
        }
        //阻塞
        System.in.read();
    }

    public static void main(String[] args) throws Exception {
        LuNioEngine engine = new LuNioEngine();
        engine.start(3);
    }
}
