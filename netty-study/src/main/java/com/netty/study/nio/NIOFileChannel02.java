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
public class NIOFileChannel02 {

    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("D:\\file01.txt");
            FileChannel channel = fis.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            channel.read(byteBuffer);
            byte[] bytes = byteBuffer.array();
            System.out.println(new String(bytes,0,bytes.length));
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
