package com.java.study.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: cxz
 * @create: 2020/9/1 17:07
 * @description:
 **/
public class NIOTest {

    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("D:\\编码测试.txt");
            FileChannel channel = fis.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int read = channel.read(byteBuffer);
            //byteBuffer.flip();
            System.out.println(new String(byteBuffer.array()));
            byteBuffer.clear();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
