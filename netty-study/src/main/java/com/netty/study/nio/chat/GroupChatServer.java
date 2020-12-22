package com.netty.study.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: cxz
 * @create: 2020/11/20 13:38
 * @description:
 **/
public class GroupChatServer {

    private final static Integer port = 6667;
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    //构造器 初始化操作
    public GroupChatServer() {
        try {
            //创建选择器
            selector = Selector.open();
            //创建severSocket
            serverSocketChannel = ServerSocketChannel.open();
            //绑定端口
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            //设置为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //将serverSocketChannel注册到selector
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //监听
    public void listen() {
        try {
            while (true) {
                int count = selector.select();//此处设置阻塞，可以设置阻塞时间，监听事件包括创建连接和读取数据
                if(count > 0){
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()){
                        SelectionKey selectionKey = iterator.next();
                        //处理事件
                        if(selectionKey.isAcceptable()){//客户端连接事件
                            //获取客户端连接
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            socketChannel.configureBlocking(false);
                            //将客户端连接注册到selector
                            socketChannel.register(selector,SelectionKey.OP_READ);
                            //提示客户端上线
                            System.out.println(socketChannel.getRemoteAddress() + " 上线 ");
                        }

                        if(selectionKey.isReadable()){//读事件
                            readData(selectionKey);
                        }
                        //处理完毕之后将当前key删除
                        iterator.remove();
                    }
                }else {
                    System.out.println("等待。。。。");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //读取客户端数据
    public void readData(SelectionKey key){
        //定一个SocketChannel
        SocketChannel socketChannel = null;
        try{
            socketChannel = (SocketChannel) key.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int count = socketChannel.read(byteBuffer);
            if(count>0){
                //System.out.println("From 客户端数据：" + new String(byteBuffer.array(),0,byteBuffer.array().length));
                //将数据发送到除了自己之外，其他所有客户端
                sendInfoToOtherClients(new String(byteBuffer.array(),0,byteBuffer.array().length),socketChannel);
            }
        }catch (IOException e){
            e.printStackTrace();
            try {
                System.out.println("客户端" + socketChannel.getRemoteAddress() + "离线了");
                //取消注册
                key.cancel();
                //关闭通道
                socketChannel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    //将消息发送到除了自己之外其他所有客户端
    public void sendInfoToOtherClients(String msg,SocketChannel self) throws IOException {
        System.out.println("服务器转发消息。。。。");
        Set<SelectionKey> keys = selector.keys();
        for (SelectionKey key : keys){
            Channel channel = key.channel();
            if(channel instanceof SocketChannel && channel != self){
                ((SocketChannel) channel).write(ByteBuffer.wrap(msg.getBytes()));
            }
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }


}
