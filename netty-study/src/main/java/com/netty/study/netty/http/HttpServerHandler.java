package com.netty.study.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: cxz
 * @create: 2020/11/23 17:00
 * @description:
 **/
//SimpleChannelInboundHandler是ChannelInboundHandlerAdapter子类
//客户端与服务器端数据被封装成HttpObject
public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {

        if(httpObject instanceof HttpRequest){
            System.out.println("msg类型：" + httpObject.getClass());
            System.out.println("客户地址：" + channelHandlerContext.channel().remoteAddress());

            //回复信息给浏览器
            ByteBuf byteBuf = Unpooled.copiedBuffer("hello，我是服务器", CharsetUtil.UTF_16);
            //构造一个http响应，即HttpResponse
            FullHttpResponse httpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, byteBuf);
            //设置响应头
            httpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
            httpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH,byteBuf.readableBytes());
            //返回给客户端
            channelHandlerContext.writeAndFlush(httpResponse);

        }
    }
}
