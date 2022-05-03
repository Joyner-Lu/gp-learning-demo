package com.joyner.gp_learning.netty_related.my_rpc_v2.service;

import com.joyner.gp_learning.netty_related.my_rpc_v2.rpc.Dispatch;
import com.joyner.gp_learning.netty_related.my_rpc_v2.rpc.transport.ServerDecoderHandler;
import com.joyner.gp_learning.netty_related.my_rpc_v2.rpc.transport.ServerRequestHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

import static com.joyner.gp_learning.netty_related.my_rpc_v2.config.Configuration.SERVER_SELECTOR_NUMS;

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
public class MyRpcProvider {

    private InetSocketAddress address;


    public MyRpcProvider(InetSocketAddress address) {
        this.address = address;

    }


    public void startProvider() {
        try {
            UserService userService = new UserServiceImpl();
            Dispatch.getInstance().register(UserService.class.getName(), userService);

            NioEventLoopGroup group = new NioEventLoopGroup(SERVER_SELECTOR_NUMS);
            ServerBootstrap bs = new ServerBootstrap();
            ChannelFuture bind = bs.group(group)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel ch) throws Exception {
                            System.out.println("client:" + ch.remoteAddress().getAddress() + ",port:" +  ch.remoteAddress().getPort());
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new ServerDecoderHandler());
                            pipeline.addLast(new ServerRequestHandler());
                        }
                    })
                    .bind(address);
            bind.sync().channel().closeFuture().sync();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }


}
