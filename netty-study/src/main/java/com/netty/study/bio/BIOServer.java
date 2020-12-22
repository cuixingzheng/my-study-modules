package com.netty.study.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: cxz
 * @create: 2020/11/17 17:26
 * @description:
 **/
public class BIOServer {

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //常见serverSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了....");
        while (true){
            //客户端连接
            final Socket socket = serverSocket.accept();//此方法会阻塞，止到有新的客户端连接
            System.out.println("连接到一个客户端....");
            //使用线程池与之通讯
            executorService.submit(() -> handler(socket));
        }
    }

    public static void handler(Socket socket){
        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            while (true){
                int read = inputStream.read(bytes);
                if(read != -1){
                    System.out.println(new String(bytes,0,read));
                }else {
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
