package com.netty.study.netty.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author: cxz
 * @create: 2020/11/30 18:52
 * @description:
 **/
public class MyClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] array = new byte[msg.readableBytes()];
        msg.readBytes(array);
        System.out.println("客户端接收消息：" + new String(array,0,array.length));
    }

    //客户端channel激活时发送数据
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //发送10条数据
        for (int i = 0; i < 10; i++) {
            ctx.writeAndFlush(Unpooled.copiedBuffer("hello world " + i, CharsetUtil.UTF_8));
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
