package com.netty.study.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * @author: cxz
 * @create: 2020/11/23 13:58
 * @description: 需要集成ChannelInboundHandlerAdapter，netty对自定义handler进行规范
 **/
public class NettyServerHandler extends ChannelInboundHandlerAdapter {


    //该方法是处理客户端读取数据ms客户端发送的数据
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println("客户端发送消息 msg is " + msg);
//        ByteBuf byteBuf = (ByteBuf)msg;
//        System.out.println("客户端发送消息 byteBug is " + byteBuf);
//        System.out.println("客户端地址：" + ctx.channel().remoteAddress());
        //假如现在有非常耗时的业务，此时需要使用异步来处理
        ctx.channel().eventLoop().execute(() -> {
            //注意当前执行的线程和channelRead是同一个线程，只是该方法需要执行完channelRead方法周才能被执行
            try {
                Thread.sleep(2000L);
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello 客户端 喵2", CharsetUtil.UTF_8));
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("发生异常");
            }
        });
        ctx.channel().eventLoop().schedule(()->{//提交到定时任务队列
            //注意当前执行的线程和channelRead是同一个线程，只是该方法需要执行完channelRead方法周才能被执行
                //Thread.sleep(3000L);
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello 客户端 喵3", CharsetUtil.UTF_8));

        },5, TimeUnit.SECONDS);
        System.out.println("server go on ...");
    }

    //该方法表示数据读取完毕之后调用
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //向客户端写数据
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello 客户端 喵1", CharsetUtil.UTF_8));

    }
}
