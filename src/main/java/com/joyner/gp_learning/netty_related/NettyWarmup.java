package com.joyner.gp_learning.netty_related;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.junit.Test;

import java.net.InetSocketAddress;

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
public class NettyWarmup {



    @Test
    public void myByteBuf() {
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer(8, 20);
        print(buf);

        buf.writeBytes(new byte[]{1, 2, 3, 4});
        print(buf);
        buf.writeBytes(new byte[]{1, 2, 3, 4});
        print(buf);

        System.out.println("release----");
        boolean r = buf.release();
        System.out.println("result:" + r);
        print(buf);

        buf.writeBytes(new byte[]{1, 2, 3, 4});
        print(buf);
        buf.writeBytes(new byte[]{1, 2, 3, 4});
        print(buf);
        buf.writeBytes(new byte[]{1, 2, 3, 4});


        System.out.println("-----before---------");
        print(buf);
        byte[] dst = new byte[4];
        buf.getBytes(0, dst);
        System.out.println("-----after---------");
        print(buf);


      /*  buf.writeBytes(new byte[]{1, 2, 3, 4});
        print(buf);*/

    }

    public void print(ByteBuf buf) {
        System.out.println("buf.isReadable():" + buf.isReadable());
        System.out.println("buf.readerIndex():" + buf.readerIndex());
        System.out.println("buf.readableBytes():" + buf.readableBytes());
        System.out.println("buf.isWritable():" + buf.isWritable());
        System.out.println("buf.writerIndex():" + buf.writerIndex());
        System.out.println("buf.writableBytes():" + buf.writableBytes());
        System.out.println("buf.capacity():" + buf.capacity());
        System.out.println("buf.maxCapacity():" + buf.maxCapacity());
        System.out.println("buf.isDirect():" + buf.isDirect());
        System.out.println("----------------------------");
    }

    @Test
    public void loopExecutor() throws Exception {
        NioEventLoopGroup selector = new NioEventLoopGroup(1);
        selector.execute(() -> {
            for (; ; ) {
                System.out.println("hello world1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        selector.execute(() -> {
            for (; ; ) {
                System.out.println("hello world2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.in.read();
    }


    /*
    客户端
    连接别人
    1，主动发送数据
    2，别人什么时候给我发？  event  selector
     */
    @Test
    public void clientMode() throws Exception {
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup(1);

        NioSocketChannel client = new NioSocketChannel();//自带了一个属性：pipeline
        //epoll_create---返回5
        eventExecutors.register(client);// epoll_ctl(5, add, 3)//注册到多路复用器。选择一个

        ChannelPipeline pipeline = client.pipeline();
        pipeline.addLast(new MyInHandler());

        ChannelFuture connect = client.connect(new InetSocketAddress("10.10.4.140", 9090));
        ChannelFuture sync = connect.sync();

        ByteBuf buf = Unpooled.copiedBuffer("hello server".getBytes());
        ChannelFuture send = client.writeAndFlush(buf);
        send.sync();

        sync.channel().closeFuture().sync();
        System.out.println("client over.");
    }



    @Test
    public void serverMode() throws Exception {
        NioEventLoopGroup selector = new NioEventLoopGroup(1);
        NioServerSocketChannel server = new NioServerSocketChannel();
        selector.register(server);

        //指不定什么时候人来
        ChannelPipeline pipeline = server.pipeline();
        //pipeline.addLast(new MyAcceptHandler(selector, new MyInHandler()));
        pipeline.addLast(new MyAcceptHandler(selector, new ChannelInit()));
        ChannelFuture bind = server.bind(new InetSocketAddress(9090));

        bind.sync().channel().closeFuture().sync();
        System.out.println("server close.");
    }


    @Test
    public void serverMode2() throws Exception {

        NioEventLoopGroup selector = new NioEventLoopGroup(1);

        NioServerSocketChannel server = new NioServerSocketChannel();
        selector.register(server);//注册到多路复用器

        //埋点
        ChannelPipeline pipeline = server.pipeline();
        pipeline.addLast(new MyAcceptHandler(selector, new ChannelInit()));


        //绑定一个handler,
        ChannelFuture sync = server.bind(new InetSocketAddress(9999)).sync();
        sync.channel().closeFuture().sync();


    }

    @Test
    public void nettyClient() throws Exception {
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bs = new Bootstrap();
        ChannelFuture connect = bs.group(group)
                .channel(NioSocketChannel.class)
                //.handler(new ChannelInit())
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new MyInHandler());
                    }
                })
                .connect(new InetSocketAddress("10.10.4.140", 9090));
        Channel client = connect.sync().channel();

        ByteBuf buf = Unpooled.copiedBuffer("hello server".getBytes());
        ChannelFuture send = client.writeAndFlush(buf);
        send.sync();


        client.closeFuture().sync();

    }

    @Test
    public void nettyServer() throws Exception {
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        ServerBootstrap bs = new ServerBootstrap();
        ChannelFuture bind = bs.group(nioEventLoopGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new MyInHandler());
                    }
                })
                .bind(new InetSocketAddress(9090));
        bind.sync().channel().closeFuture().sync();


    }



}
