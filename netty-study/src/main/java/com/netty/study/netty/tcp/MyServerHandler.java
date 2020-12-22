package com.netty.study.netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * @author: cxz
 * @create: 2020/11/26 16:57
 * @description:
 **/
public class MyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private Integer count = 0;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] array = new byte[msg.readableBytes()];
        msg.readBytes(array);
        System.out.println("服务端接收消息msg：" + new String(array,0,array.length));
        System.out.println("服务器接收消息数量count：" + ++count);
        //服务器端发送数据到客户端
        ctx.writeAndFlush(Unpooled.copiedBuffer(UUID.randomUUID().toString(), CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
