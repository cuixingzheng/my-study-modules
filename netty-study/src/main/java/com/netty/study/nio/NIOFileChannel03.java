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
public class NIOFileChannel03 {

    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("D:\\file01.txt");
            FileChannel channel = fis.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            FileOutputStream fos = new FileOutputStream("D:\\file02.txt");
            FileChannel fosChannel = fos.getChannel();
            while (true){
                //需要将byteBuffer清空
                byteBuffer.clear();
                int read = channel.read(byteBuffer);
                if(read != -1){
                    //需要将byteBuffer反转
                    byteBuffer.flip();
                    fosChannel.write(byteBuffer);
                }else {
                    break;
                }
            }
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
