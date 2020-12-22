package com.netty.study.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author: cxz
 * @create: 2020/11/23 15:00
 * @description:
 **/
public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    //该方法在通道就绪之后就会被调用（连接到服务器后）
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client：" + ctx);
        //连接成功后发送数据
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello server", CharsetUtil.UTF_8));
    }

    //读取服务端数据
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("服务器回复消息：" + byteBuf.toString(CharsetUtil.UTF_8));
    }

    //抛出异常时调用
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
