package com.netty.study.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author: cxz
 * @create: 2020/11/25 10:30
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
                    .handler(new LoggingHandler(LogLevel.WARN))//设置handler日志级别
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            //基于http协议,使用http编码和解码器
                            pipeline.addLast(new HttpServerCodec());
                            //websocket是以块方式写，需添加ChunkedWriteHandler
                            pipeline.addLast(new ChunkedWriteHandler());
                            //http在传输过程中是分段的，而HttpObjectAggregator可以将其聚合
                            //这就是http在发送大数据量时会发生多次请求
                            pipeline.addLast(new HttpObjectAggregator(8192));
                            //1.对应websocket，它的数据是以帧（frame）形式传递
                            //2.可以看到WebSockedFrame下有六个子类
                            //3.浏览器请求时 ws://localhost:7000/hello表示请求uri地址
                            //4.WebSocketServerProtocolHandler核心功能是将http协议升级为ws协议，保持长连接
                            pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));
                            //添加自定义handler
                            pipeline.addLast(new MyTextWebSocketFrameHandler());

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
