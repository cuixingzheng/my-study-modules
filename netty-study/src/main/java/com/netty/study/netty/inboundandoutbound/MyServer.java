package com.netty.study.netty.inboundandoutbound;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author: cxz
 * @create: 2020/11/25 15:08
 * @description:
 **/
public class MyServer {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();//默认启动线程数为cpu数*2
        try {
            //声明服务启动参数
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class) //NioServerSocketChannel
                    .handler(new LoggingHandler(LogLevel.INFO))//设置handler日志级别
                    .childHandler(new MyServerChannelInitializer());
            //启动服务器并绑定端口
            ChannelFuture channelFuture = serverBootstrap.bind(7000).sync();
            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
            //启动服务端，使用搜狗或360浏览器访问
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
