package com.netty.study.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author: cxz
 * @create: 2020/11/23 11:15
 * @description:
 **/
public class NettyServer {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();//默认启动线程数为cpu数*2
        try {
            //声明服务启动参数
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class) //NioServerSocketChannel
                    .option(ChannelOption.SO_BACKLOG,128)//设置线程队列得到连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE,true)//设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            //打印hashcode
                            System.out.println("channel hashcode：" + channel.hashCode());
                            channel.pipeline().addLast(new NettyServerHandler());
                        }
                    }); //对workerGroup设置管道处理器

            System.out.println("服务器 is ready ...");
            //启动服务器并绑定端口
            ChannelFuture channelFuture = serverBootstrap.bind(6668).sync();
            //对channelFuture添加监听，例如判断绑定端口是否成功
            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if(future.isSuccess()){
                        System.out.println("绑定端口6668成功");
                    }else {
                        System.out.println("绑定端口6668失败");
                    }
                }
            });

            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();



        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
