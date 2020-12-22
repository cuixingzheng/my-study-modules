package com.netty.study.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author: cxz
 * @create: 2020/11/20 15:05
 * @description:
 **/
public class GroupChatClient {

    private final static String HOST = "127.0.0.1";
    private final static int PORT = 6667;
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;

    public GroupChatClient() throws IOException {
        selector = Selector.open();
        socketChannel = SocketChannel.open(new InetSocketAddress(HOST,PORT));
        //设置为非阻塞
        socketChannel.configureBlocking(false);
        //注册到selector
        socketChannel.register(selector, SelectionKey.OP_READ);
        username = socketChannel.getLocalAddress().toString().substring(1);
    }

    public void sendInfo(String info) throws IOException {
        info = username + "说：" + info;
        socketChannel.write(ByteBuffer.wrap(info.getBytes()));
    }

    public void readInfo() {
        try {
            int count = selector.select();//此处为阻塞，可以设置阻塞时间
            if(count > 0){
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey next = iterator.next();
                    if(next.isReadable()){
                        SocketChannel channel = (SocketChannel)next.channel();
                        channel.configureBlocking(false);
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        channel.read(byteBuffer);
                        System.out.println("From 服务器接收消息：" + new String(byteBuffer.array(),0,byteBuffer.array().length));
                    }
                    iterator.remove();//删除已处理事件
                }
            }else {
                //设置为非阻塞时有意义
                //System.out.println("没有可用通道");
            }
        }catch (IOException e){
            e.getStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        //初始化客户端
        GroupChatClient groupChatClient = new GroupChatClient();
        //启动一个线程从服务器读取数据
        new Thread(() ->{
            while (true){
                groupChatClient.readInfo();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //客户端发送数据
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String next = scanner.nextLine();
            groupChatClient.sendInfo(next);
        }
    }

}
