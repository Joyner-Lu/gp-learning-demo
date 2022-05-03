package com.joyner.gp_learning.java_basic.socket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

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
public class NioSocketClient {

    public static void main(String[] args) throws Exception {
        Selector selector = Selector.open();
        SocketChannel client = SocketChannel.open();
        client.configureBlocking(false);
        client.connect(new InetSocketAddress("10.10.4.140", 9090));
        client.register(selector, SelectionKey.OP_CONNECT);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            int conns = selector.select();
            if (conns > 0) {
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isConnectable()) {
                        if (client.finishConnect()) {
                            System.out.println("连接成功,并注册读取事件");
                            client.register(selector, SelectionKey.OP_READ);
                            client.write(ByteBuffer.wrap("hello server".getBytes()));
                        }
                    } else if (key.isReadable()) {
                        while (true) {
                            int r = client.read(buffer);
                            if (r <= 0) {
                                break;
                            }
                            buffer.flip();
                            byte[] dst = new byte[buffer.limit()];
                            buffer.get(dst);
                            System.out.print(new String(dst));

                            //读取完毕，写回去
                            client.write(ByteBuffer.wrap(dst));

                            buffer.clear();



                        }
                    }

                }

            }
        }


    }
}
