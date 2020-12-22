package com.netty.study.netty.http;

import com.netty.study.netty.simple.NettyServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author: cxz
 * @create: 2020/11/23 17:00
 * @description:
 **/
public class HttpServer {


    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();//默认启动线程数为cpu数*2
        try {
            //声明服务启动参数
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class) //NioServerSocketChannel
                    .childHandler(new HttpServerInitializer()); //对workerGroup设置管道处理器
            System.out.println("服务器 is ready ...");
            //启动服务器并绑定端口
            ChannelFuture channelFuture = serverBootstrap.bind(6669).sync();
            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
            //启动服务端，使用搜狗或360浏览器访问
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
