package com.netty.study.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author: cxz
 * @create: 2020/11/24 14:31
 * @description:
 **/
public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {
    //定义一个channel组，管理所有channel,该对象为单例
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

    //当handler被添加到channel的pipeline后被调用 步骤1
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //将该客户端上线信息发送给其他客户端
        channelGroup.writeAndFlush("[客户端]：" + ctx.channel().remoteAddress() + "加入聊天");
        channelGroup.add(ctx.channel());
    }
    //当handler从channel的pipeline中移除后被调用,将信息发送给其他在线用户 步骤4
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channelGroup.writeAndFlush("[客户端]：" + ctx.channel().remoteAddress() + "退出聊天");
        //注意此时不需要删除当前channel，channelGroup自动维护。
        System.out.println("channelGroup size = " + channelGroup.size());
    }

    //当channel激活时被调用，提示当前xx上线 步骤2
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "上线了");
    }

    //当channel处于非活动时被调用 步骤3
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "离线了");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        //获取当前channel
        Channel channel = channelHandlerContext.channel();
        channelGroup.forEach(ch ->{
            if(ch != channel){//如果不是当前channel，将数据发送
                ch.writeAndFlush("[客户端]" + channel.remoteAddress() + "发送消息：" + s + "\n");
            }else {
                ch.writeAndFlush("[自己]" + channel.remoteAddress() + "发送消息：" + s + "\n");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
