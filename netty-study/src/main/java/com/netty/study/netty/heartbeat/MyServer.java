package com.netty.study.netty.heartbeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author: cxz
 * @create: 2020/11/24 18:26
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
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //IdleStateHandler ： 是netty提供处理空闲连接handler
                            //readerIdleTime :表示多久未读 需要发送一次心跳检测
                            //writerIdleTime :表示多久未写 需要发送一次心跳检测
                            //allIdleTime :表示多久未读并未写 需要发送一次心跳检测
                            //当IdleStateHandler触发后，就会传给下一个handler去处理,并调用下一个handler的userEventTriggered方法
                            socketChannel.pipeline().addLast(new IdleStateHandler(3,5,7, TimeUnit.SECONDS));
                            //自定义handler
                            socketChannel.pipeline().addLast(new MyServerHandler());
                        }
                    });
            //启动服务器并绑定端口
            ChannelFuture channelFuture = serverBootstrap.bind(6668).sync();
            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
            //启动服务端，使用搜狗或360浏览器访问
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
