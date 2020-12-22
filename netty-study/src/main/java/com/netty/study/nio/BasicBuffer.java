package com.netty.study.nio;

import java.nio.IntBuffer;

/**
 * @author: cxz
 * @create: 2020/11/17 18:04
 * @description:
 **/
public class BasicBuffer {

    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(5);
        for (int i=0;i<intBuffer.capacity();i++){
            intBuffer.put(i*3);
        }
        intBuffer.flip();
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
}
