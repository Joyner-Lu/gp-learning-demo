package com.joyner.gp_learning.java_basic.io.nio;

import org.apache.ibatis.annotations.SelectKey;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Date;
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
public class TestNonblockingClient {

    public static void main(String[] args) throws Exception{
        //TODO Scanner的问题：https://blog.csdn.net/kiki_jay/article/details/82315653
        //在@Test无法输入
        //1.获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
        //2.切换非阻塞模式
        sChannel.configureBlocking(false);
        //3.分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //4.发送数据给服务端
        Scanner scan = new Scanner(System.in);

        Selector selector = Selector.open();
        sChannel.register(selector, SelectionKey.OP_READ);

        while (scan.hasNext()) {
            String str = scan.next();
            buf.put((new Date().toString() + "\n" + str).getBytes());
            buf.flip();
            sChannel.write(buf);
            buf.clear();

            //写完毕之后，去检查是否有数据过来
            while (selector.selectNow() > 0) {
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey next = iterator.next();
                    iterator.remove();
                    if (next.isReadable()) {
                        //处理读取事件
                        sChannel.read(buf);
                        buf.flip();
                        byte[] data = new byte[buf.limit()];
                        buf.get(data);
                        String s = new String(data);
                        System.out.println("服务器端发送的数据：" + s);
                        buf.clear();
                    }
                }
            }
        }
        //5.关闭通道
        sChannel.close();

    }
}
