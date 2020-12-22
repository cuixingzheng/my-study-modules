package com.netty.study.netty.inboundandoutbound;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author: cxz
 * @create: 2020/11/30 10:05
 * @description: 自定义编码
 **/

public class MyLongToByteEncoderHandler extends MessageToByteEncoder<Long> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {

        System.out.println("MyLongToByteEncoderHandler中 encode 被调用");
        System.out.println("msg = " + msg);
        out.writeLong(msg);

    }
}
