package com.netty.study.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/**
 * @author: cxz
 * @create: 2020/11/24 13:57
 * @description:
 **/
public class NettyByteBufTest02 {

    public static void main(String[] args) {
        //ByteBuf是netty提供的字节缓存对象
        //ByteBuf中不需要使用flip进行反转
        //底层维护了readIndex和writeIndex
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello world", CharsetUtil.UTF_8);

        if(byteBuf.hasArray()){
            byte[] bytes = byteBuf.array();
            System.out.println(new String(bytes));
            System.out.println("arrayOffset = " + byteBuf.arrayOffset());
            System.out.println("readerIndex = " + byteBuf.readerIndex());
            System.out.println("writerIndex = " + byteBuf.writerIndex());
        }

    }
}
