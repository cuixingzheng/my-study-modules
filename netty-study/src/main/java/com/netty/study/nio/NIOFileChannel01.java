package com.netty.study.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: cxz
 * @create: 2020/11/19 17:37
 * @description:
 **/
public class NIOFileChannel01 {

    public static void main(String[] args) {

        try {
            String msg = "hello netty";
            FileOutputStream fos = new FileOutputStream("D:\\file01.txt");
            FileChannel channel = fos.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put(msg.getBytes());
            byteBuffer.flip();
            channel.write(byteBuffer);

            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
