package com.netty.study.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author: cxz
 * @create: 2020/11/25 10:11
 * @description:
 **/
public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            String eventInfo = null;
            switch (idleStateEvent.state()){
                case READER_IDLE:
                    eventInfo = "读空闲";
                    break;
                case WRITER_IDLE:
                    eventInfo = "写空闲";
                    break;
                case ALL_IDLE:
                    eventInfo = "读写空闲";
                    break;
            }
            System.out.println(eventInfo + ",空闲客户端地址：" + ctx.channel().remoteAddress());
        }
    }
}
