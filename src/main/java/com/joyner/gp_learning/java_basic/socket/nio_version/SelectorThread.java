package com.joyner.gp_learning.java_basic.socket.nio_version;

import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

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
public class SelectorThread extends ThreadLocal<LinkedBlockingDeque<Channel>> implements Runnable {

    private Selector selector;
    private SelectorThreadGroup stg;
    private LinkedBlockingDeque<Channel> queue = get();

    public SelectorThread(SelectorThreadGroup stg) {
        try {
            selector = Selector.open();
            this.stg = stg;
        } catch (Exception ex) {
            throw new RuntimeException("open selector fail.", ex);
        }
    }

    @Override
    protected LinkedBlockingDeque<Channel> initialValue() {
        return new LinkedBlockingDeque<>();
    }

    @Override
    public void run() {
        try {
            //loop
            while (true) {

                //1.select
                int readNums = selector.select();
                //System.out.println(Thread.currentThread().getName() + " after key size:" + selector.selectedKeys().size());
                if (readNums > 0) {
                    //2.processSelectKeys
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = keys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();//移除
                        if (key.isAcceptable()) {
                            //有客户端进来了
                            acceptHandle(key);
                        } else if (key.isReadable()) {
                            //有客户端写数据了
                            readHandle(key);
                        } else if (key.isWritable()) {
                            //可以写数据了 TODO 暂时不处理
                        }

                    }
                }


                //3.run other task（调用wakeup进入的逻辑）
                if (!queue.isEmpty()) {
                    Channel channel = queue.take();
                    if (channel instanceof ServerSocketChannel) {
                        ServerSocketChannel server = (ServerSocketChannel) channel;
                        server.register(selector, SelectionKey.OP_ACCEPT);

                    } else if (channel instanceof SocketChannel) {
                        SocketChannel client = (SocketChannel) channel;
                        ByteBuffer buffer = ByteBuffer.allocate(4096);
                        client.register(selector, SelectionKey.OP_READ, buffer);
                    }
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("process fail.", ex);
        }


    }

    private void readHandle(SelectionKey key) throws Exception {
        System.out.println(Thread.currentThread().getName() + " read...");
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.clear();
        int readNums = 0;
        while (true) {
            //开始读取
            //buffer.flip();//buffer刚开始是没有数据的，因此这里的处理会导致limit为0，那么client.read(buffer);肯定读不进去
            readNums = client.read(buffer);
            if (readNums > 0) {
                buffer.flip();//读到limit
                while (buffer.hasRemaining()) {
                    client.write(buffer);
                }
            } else if (readNums == 0) {
                //读取完毕，跳出本次循环
                break;
            } else {
                //客户端退出
                System.out.println(Thread.currentThread().getName() + " client closed:" + client.getRemoteAddress());
                key.cancel();//从selector里面移除
                client.close();
                break;
            }
        }

    }

    /**
     * 处理读
     *
     * @param key
     */
    private void acceptHandle(SelectionKey key) throws Exception {
        System.out.println(Thread.currentThread().getName() + " accept...");
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel client = serverSocketChannel.accept();
        client.configureBlocking(false);

        // 随机获取selector 并注册
        /*
        //TODO 不能在这里进行,因为selector.select();已经阻塞了。这里根本不会注册进去

        ByteBuffer buffer = ByteBuffer.allocate(4096);
        client.register(selector, SelectionKey.OP_READ, buffer);*/
        //处理
        stg.nextWorkerSelector(client);
    }

    public Selector getSelector() {
        return selector;
    }

    public LinkedBlockingDeque<Channel> getQueue() {
        return queue;
    }
}
