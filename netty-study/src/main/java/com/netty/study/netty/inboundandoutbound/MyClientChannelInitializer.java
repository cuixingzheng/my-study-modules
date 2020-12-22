package com.netty.study.netty.inboundandoutbound;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author: cxz
 * @create: 2020/11/26 17:57
 * @description:
 **/
public class MyClientChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        //客户端发送数据时设置编码器
        ch.pipeline().addLast(new MyLongToByteEncoderHandler());
        //添加自定义handler
        ch.pipeline().addLast(new MyClientHandler());
    }
}
