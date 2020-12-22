package com.netty.study.netty.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;

/**
 * @author: cxz
 * @create: 2020/11/25 11:08
 * @description:
 **/
//TextWebSocketFrame表示一个文本帧（frame）
public class MyTextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {

        System.out.println("服务器收到消息：" + textWebSocketFrame.text());
        //服务器回复消息
        channelHandlerContext.channel().writeAndFlush(new TextWebSocketFrame("服务器时间：" + LocalDateTime.now() + "," + textWebSocketFrame.text()));
    }

    //表示向channel添加handler后被调用（第一个被调用）
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //id表示channel唯一值，asLongText是唯一的，asShortText不是唯一的
        System.out.println("handlerAdded 被调用" + ctx.channel().id().asLongText());
    }

    //表示向channel删除handler后被调用（最后一个被调用）
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved 被调用" + ctx.channel().id().asLongText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getMessage());
        ctx.close();
    }
}
