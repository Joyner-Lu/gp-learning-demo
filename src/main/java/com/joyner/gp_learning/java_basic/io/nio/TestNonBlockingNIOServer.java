package com.joyner.gp_learning.java_basic.io.nio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Scanner;
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
public class TestNonBlockingNIOServer {

    @Test
    public void server() throws Exception {
        ServerSocketChannel server = ServerSocketChannel.open();
        //设置非阻塞
        server.configureBlocking(false);
        //绑定连接
        server.bind(new InetSocketAddress(9999));

        //获取选择器（也就是多路复用器）
        Selector selector = Selector.open();

        //注册到多路复用器，让多路复用器来处理事件
        server.register(selector, SelectionKey.OP_ACCEPT);

        //获取选择器是否有准备好的事件
        while (selector.select() > 0) {
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                iterator.remove();//需要进行清除

                if (next.isAcceptable()) {
                    //有连接进来
                    SocketChannel client = server.accept();
                    System.out.println("连接进来了：" + client.getRemoteAddress());
                    //TODO 需要切换为非阻塞，否则不可用
                    client.configureBlocking(false);
                    //注册到多路复用器
                    client.register(selector, SelectionKey.OP_READ);


                } else if (next.isReadable()) {
                    SocketChannel client = (SocketChannel) next.channel();
                    SocketAddress remoteAddress = client.getRemoteAddress();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int r = 0;
                    while ((r = client.read(buffer)) > 0) {
                        buffer.flip();
                        byte[] data = new byte[buffer.limit()];
                        buffer.get(data);
                        System.out.print("接收到("+remoteAddress+")的数据:" + new String(data));
                        buffer.clear();//清除读取的数据

                        //告知数据已收到
                        buffer.put("你好已收到数据".getBytes());
                        buffer.flip();
                        client.write(buffer);
                        buffer.clear();
                    }
                }


            }
        }


    }

}
