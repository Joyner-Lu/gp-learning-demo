package com.joyner.gp_learning.java_basic.io.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/*
 * 一、通道(Channel):用于源节点与目标节点的连接。在java NIO中负责缓冲区中数据的传输。Channel本身不存储数据，需要配合缓冲区进行传输。
 *
 * 二、通道的主要实现类
 *    java.nio.channels.Channel 接口：
 *        |--FileChannel：用于读取、写入、映射和操作文件的通道。
 *        |--SocketChannel：通过 TCP 读写网络中的数据。
 *        |--ServerSocketChannel：可以监听新进来的 TCP 连接，对每一个新进来的连接都会创建一个 SocketChannel。
 *        |--DatagramChannel：通过 UDP 读写网络中的数据通道。
 *
 * 三、获取通道
 * 1.java针对支持通道的类提供了getChannel()方法
 *      本地IO：
 *      FileInputStream/FileOutputStream
 *      RandomAccessFile
 *
 *      网络IO：
 *      Socket
 *      ServerSocket
 *      DatagramSocket
 *
 * 2.在JDK 1.7 中的NIO.2 针对各个通道提供了静态方法 open()
 * 3.在JDK 1.7 中的NIO.2 的Files工具类的newByteChannel()
 *
 * 四、通道之间的数据传输
 * transferFrom()
 * transferTo()
 *
 * 五、分散(Scatter)与聚集(Gather)
 * 分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区中
 * 聚集写入（Gathering Writes）：将多个缓冲区中的数据聚集到通道中
 *
 * 六、字符集：Charset
 * 编码：字符串-》字符数组
 * 解码：字符数组-》字符串
 */
public class TestChannel {

    /**
     * 传统的文件复制方式
     * @throws Exception
     */
    @Test
    public void test01() throws Exception{
        //3589
        long currentTimeMillis = System.currentTimeMillis();

        byte buf[] = new byte[8192];

        FileInputStream fileInputStream = new FileInputStream("D:\\上班资料\\常用软件安装包\\PowerDesigner 16.5.zip");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\上班资料\\常用软件安装包\\PowerDesigner 16.5.zip_copy");

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream =new BufferedOutputStream(fileOutputStream);

        int r = -1;
        while ((r = bufferedInputStream.read(buf)) != -1) {
            bufferedOutputStream.write(buf, 0, r);
        }

        bufferedInputStream.close();
        fileInputStream.close();

        bufferedOutputStream.flush();
        fileOutputStream.flush();
        bufferedOutputStream.close();
        fileOutputStream.close();

        long end = System.currentTimeMillis();
        System.out.println(end - currentTimeMillis);


    }

    /**
     * 使用通道，没啥本职区别
     * @throws Exception
     */
    @Test
    public void test02() throws Exception{
        //6447
        long currentTimeMillis = System.currentTimeMillis();


        FileInputStream fileInputStream = new FileInputStream("D:\\上班资料\\常用软件安装包\\PowerDesigner 16.5.zip");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\上班资料\\常用软件安装包\\PowerDesigner 16.5.zip_copy");

        //1.获取通道
        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();


        //2.分配指定缓冲区大小
        ByteBuffer buf = ByteBuffer.allocate(8192);

        int r = -1;
        while ((r = inChannel.read(buf)) != -1) {
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - currentTimeMillis);


    }

    /**
     * 内存映射文件
     * @throws Exception
     */
    @Test
    public void test03() throws Exception {
        //8973
        long currentTimeMillis = System.currentTimeMillis();

        /*FileInputStream fileInputStream = new FileInputStream("D:\\上班资料\\常用软件安装包\\PowerDesigner 16.5.zip");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\上班资料\\常用软件安装包\\PowerDesigner 16.5.zip_copy");
        */


        //1.获取通道
        FileChannel inChannel = FileChannel.open(Paths.get("D:\\上班资料\\常用软件安装包\\PowerDesigner 16.5.zip"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("D:\\上班资料\\常用软件安装包\\PowerDesigner 16.5.zip_copy"), StandardOpenOption.READ, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        MappedByteBuffer inMap = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMap = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //byte[] dst = new byte[inMap.limit()];
        //inMap.get(dst);
        outMap.put(inMap);//直接在内核级别做拷贝。

        long end = System.currentTimeMillis();
        System.out.println(end - currentTimeMillis);
    }

    //  //通道之间的数据传输(直接缓冲区)
    //send file
    @Test
    public void test04() throws Exception {
        long currentTimeMillis = System.currentTimeMillis();

        FileChannel inChannel = FileChannel.open(Paths.get("D:\\上班资料\\常用软件安装包\\PowerDesigner 16.5.zip"), StandardOpenOption.READ);
        FileChannel outCHannel = FileChannel.open(Paths.get("D:\\上班资料\\常用软件安装包\\PowerDesigner 16.5.zip_copy"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        inChannel.transferTo(0, inChannel.size(), outCHannel);
        //outCHannel.transferFrom(inChannel, 0, inChannel.size());
        long end = System.currentTimeMillis();
        System.out.println(end - currentTimeMillis);
    }

    /**
     * 分散和聚集
     */
    @Test
    public void test05() throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\上班资料\\常用软件安装包\\test.txt", "rw");
        //1.获取通道
        FileChannel channel = randomAccessFile.getChannel();

        //2.分配指定的缓冲区大小
        ByteBuffer buf1 = ByteBuffer.allocate(5);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        //3.分散 读取
        ByteBuffer[] bufs = {buf1, buf2};
        channel.read(bufs);
        for(ByteBuffer byteBuffer : bufs){
            byteBuffer.flip();
        }
        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
        System.out.println("--------------------");
        System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));

        //4.聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("D:\\上班资料\\常用软件安装包\\test_copy.txt", "rw");
        FileChannel channel2 = raf2.getChannel();
        channel2.write(bufs);





    }

}
