package com.netty.study.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: cxz
 * @create: 2020/11/19 18:35
 * @description: 使用堆外内存映射修改文件，不需要操作系统拷贝数据，效率高
 **/
public class NIOMappedByteBufferTest {

    public static void main(String[] args) {

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\file01.txt","rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            //获取到MappedByteBuffer，实际子类是DirectByteBuffer
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
            mappedByteBuffer.put(0,(byte) ('a'));
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
