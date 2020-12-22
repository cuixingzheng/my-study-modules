package com.netty.study.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author: cxz
 * @create: 2020/11/23 17:09
 * @description:
 **/
public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

        ChannelPipeline pipeline = socketChannel.pipeline();
        //添加netty提供的httpServerCodec编解码器
        pipeline.addLast("MyHttpServerCodec",new HttpServerCodec());
        //添加自定义handler
        pipeline.addLast("HttpServerHandler",new HttpServerHandler());
    }
}
