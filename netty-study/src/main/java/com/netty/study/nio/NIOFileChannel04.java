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
 * @description: 文件拷贝
 **/
public class NIOFileChannel04 {

    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("D:\\file01.txt");
            FileOutputStream fos = new FileOutputStream("D:\\file03.txt");
            FileChannel channel = fis.getChannel();
            FileChannel fosChannel = fos.getChannel();
            fosChannel.transferFrom(channel,0,channel.size());
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
