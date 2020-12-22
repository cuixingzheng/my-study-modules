package com.netty.study.netty.inboundandoutbound;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author: cxz
 * @create: 2020/11/25 15:17
 * @description:
 **/
public class MyByteToLongDecoderHandler extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if(in.capacity()>8){//字节数量超过8个才会添加
            out.add(in.readLong());
        }





    }
}
