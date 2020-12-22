package com.netty.study.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author: cxz
 * @create: 2020/11/24 13:57
 * @description:
 **/
public class NettyByteBufTest01 {

    public static void main(String[] args) {
        //ByteBuf是netty提供的字节缓存对象
        //ByteBuf中不需要使用flip进行反转
        //底层维护了readIndex和writeIndex
        ByteBuf byteBuf = Unpooled.buffer(10);

        for (int i = 0; i < 10; i++) {
            byteBuf.writeByte(i);
        }
        for (int i = 0; i < byteBuf.capacity(); i++) {
            System.out.println(byteBuf.getByte(i));
        }
    }
}
