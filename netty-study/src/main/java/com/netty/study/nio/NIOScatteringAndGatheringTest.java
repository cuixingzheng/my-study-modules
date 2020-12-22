package com.netty.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author: cxz
 * @create: 2020/11/19 18:51
 * @description:
 * Scattering：分散数组
 * Gathering：聚集数组
 **/
public class NIOScatteringAndGatheringTest {

    public static void main(String[] args) {
        //使用telnet 127.0.0.1 7000 之后ctrl + ] ,send hello
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
            serverSocketChannel.socket().bind(inetSocketAddress);
            ByteBuffer[] byteBuffers = new ByteBuffer[2];
            byteBuffers[0] = ByteBuffer.allocate(2);
            byteBuffers[1] = ByteBuffer.allocate(3);
            //等待客户端连接
            SocketChannel socketChannel = serverSocketChannel.accept();
            int messageLength = 5;
            while (true){
                int byteRead = 0;
                while (byteRead < messageLength){//只读取messageLength长度字节数
                    long l = socketChannel.read(byteBuffers);
                    byteRead += l;
                    Arrays.asList(byteBuffers).stream().map(buffer -> "position : " + buffer.position() + ", limit : " + buffer.limit() + ",str : " + new String(buffer.array(),0,buffer.array().length)).
                            forEach(System.out::println);
                }
            //将数据写会客户端
                Arrays.asList(byteBuffers).forEach(Buffer::flip);
                long byteWrite = 0;
                while (byteWrite < messageLength){
                    long l = socketChannel.write(byteBuffers);
                    byteWrite += l;
                }
                //将所有byteBuffer
                Arrays.asList(byteBuffers).forEach(Buffer::clear);
                System.out.println(" byteRead :" + byteRead  + ", byteWrite : " + byteWrite);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
