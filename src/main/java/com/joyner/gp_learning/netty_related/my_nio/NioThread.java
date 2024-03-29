package com.joyner.gp_learning.netty_related.my_nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Set;

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
public class NioThread extends Thread {

    private Selector selector;

    private int id;

    private String name;

    private boolean isBoss;

    public NioThread(Selector selector, int id, boolean isBoss) {
        this.selector = selector;
        this.id = id;
        if (isBoss) {
            name = "boss-" + id;
        } else {
            name = "worker-" + id;
        }
        setName(name);
        this.isBoss = isBoss;
    }

    @Override
    public void run()  {
        while (true) {
            try {
                while (selector.select(10) > 0) {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    for (SelectionKey selectionKey : selectionKeys) {
                        selectionKeys.remove(selectionKey);
                        if (selectionKey.isAcceptable()) {
                            acceptNew(selectionKey);
                        } else if (selectionKey.isReadable()) {
                            readHandler(selectionKey);
                        }
                    }
                }

                if (!isBoss && !LuNioEngine.queues[id].isEmpty()) {
                    SocketChannel client = LuNioEngine.queues[id].poll();
                    client.register(selector, SelectionKey.OP_READ);
                    System.out.println(name + " register client(read event):" + client.getRemoteAddress());
                }


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    private void readHandler(SelectionKey selectionKey) {
        SocketChannel client = (SocketChannel) selectionKey.channel();
        ByteBuffer buffer = ByteBuffer.allocate(8192);
        try {
            int read = client.read(buffer);
            if (read > 0) {
                buffer.clear();
                buffer.put((name + " got it\n").getBytes());
                buffer.flip();
                client.write(buffer);
            } else if (read == 0) {
                System.out.println(name + " read data is 0");
            } else {
                System.out.println(name + " read data is -1");
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void acceptNew(SelectionKey selectionKey) throws Exception {
        SelectableChannel channel = selectionKey.channel();
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) channel;
        SocketChannel client = serverSocketChannel.accept();
        client.configureBlocking(false);
        System.out.println(name + " accept new client:" + client.getRemoteAddress());
        //扔到队列里面
        int idx = LuNioEngine.idx.getAndIncrement() % LuNioEngine.workerCount;
        LuNioEngine.queues[idx].offer(client);
    }
}
