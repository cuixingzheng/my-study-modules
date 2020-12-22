package com.netty.study.netty.groupchat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author: cxz
 * @create: 2020/11/24 14:20
 * @description:
 **/
public class GroupChatServer {

    private Integer port;

    public GroupChatServer(Integer port) {
        this.port = port;
    }

    public void run() throws InterruptedException {
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
                            //System.out.println("channel hashcode：" + channel.hashCode());
                            //添加netty自带的解码器
                            channel.pipeline().addLast("decoder",new StringDecoder());
                            //添加netty自带的编码器
                            channel.pipeline().addLast("encoder",new StringEncoder());
                            //加入自定义handler
                            channel.pipeline().addLast(new GroupChatServerHandler());
                        }
                    }); //对workerGroup设置管道处理器

            //启动服务器并绑定端口
            ChannelFuture channelFuture = serverBootstrap.bind(6668).sync();
            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new GroupChatServer(7000).run();
    }
}
