package com.joyner.gp_learning.java_basic.io.nio;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/*
 * 一、使用NIO 完成网络通信的三个核心：
 *
 * 1、通道(Channel):负责连接
 *      java.nio.channels.Channel 接口：
 *           |--SelectableChannel
 *               |--SocketChannel
 *               |--ServerSocketChannel
 *               |--DatagramChannel
 *
 *               |--Pipe.SinkChannel
 *               |--Pipe.SourceChannel
 *
 * 2.缓冲区(Buffer):负责数据的存取
 *
 * 3.选择器(Selector):是 SelectableChannel 的多路复用器。用于监控SelectableChannel的IO状况
 */
public class TestBlockingNIO {


    @Test
    public void server() throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //绑定端口
        serverSocketChannel.bind(new InetSocketAddress(9999));
        //开始接收连接
        SocketChannel client = serverSocketChannel.accept();

        //有连接进来之后，开始读取数据
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int r = 0;
        while ((r = client.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            byte[] b = new byte[byteBuffer.limit()];
            byteBuffer.get(b);
            String inComeData = new String(b);
            if (inComeData.startsWith("bye")) {
                break;
            }
            System.out.println("接收到的数据..." + inComeData);
            byteBuffer.clear();
        }

        byteBuffer.clear();
        byteBuffer.put("服务器接收数据成功".getBytes());
        byteBuffer.flip();
        client.write(byteBuffer);

        System.in.read();
        //关闭
        client.close();
        serverSocketChannel.close();
    }
}
