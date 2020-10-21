package com.java.study.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author: cxz
 * @create: 2020/8/26 18:49
 * @description:
 **/
public class ByteStreamTest {
    private static String path = "D:\\编码测试.txt" ;

    public static void main(String[] args) {
        //fileStream();
        //bufferedStream();
        //byteArrayStream();
        //dataStream();
        //objectStream();
        printStream();
    }

    private static void fileStream() {
        String info = "学习字节流";
        File file = new File("D:\\编码测试.txt");
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream(file);
            //fos.write(info.getBytes()); 不设置编码方式时默认使用平台编码方式（idea工具使用文件文件编码方式）
            fos.write(info.getBytes(StandardCharsets.UTF_8));//也可以单独设置编码方式
            fis = new FileInputStream(file);
            int read ;
            byte[] bytes = new byte[1024];
            int i = 0;
            while ((read = fis.read()) != -1){
                bytes[i] = (byte) read;
                i++;
            }
            //System.out.println(new String(bytes)); 默认使用平台解码方式
            System.out.println(new String(bytes,StandardCharsets.UTF_8));//进行解码时要去前面的编码方式保持一致
            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferedStream(){
        String info = "学习字节缓冲流";
        File file = new File("D:\\编码测试.txt");
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(info.getBytes(StandardCharsets.UTF_8));//也可以单独设置编码方式
            bos.close();//注意写完就把缓冲流关闭了，之后关闭可能读取不到数据，原因缓冲流没有达到固定值时，不会进行写操作
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            int read ;
            byte[] bytes = new byte[1024];
            int i = 0;
            while ((read = bis.read()) != -1){
                bytes[i] = (byte) read;
                i++;
            }
            System.out.println(new String(bytes,StandardCharsets.UTF_8));//进行解码时要去前面的编码方式保持一致
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void byteArrayStream(){
        String info = "字节数组缓存流";
        ByteArrayOutputStream baos = null;
        ByteArrayInputStream bais = null;
        try {
            baos = new ByteArrayOutputStream();
            baos.write(info.getBytes());
            baos.close();
            bais = new ByteArrayInputStream(baos.toByteArray());
            byte[] bytes = new byte[1024];
            int i=0;
            int read;
            while ((read=bais.read())!=-1){
                bytes[i]=(byte) read;
                i++;
            }
            bais.read();
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dataStream(){
        Integer num = 95;
        char ch = 'A';
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("D:\\002.txt"));//
            dos.writeInt(num);
            dos.writeChar(ch);
            dos.close();
            DataInputStream dis = new DataInputStream(new FileInputStream("D:\\002.txt"));
            System.out.println(dis.readInt());
            System.out.println(dis.readChar());
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void objectStream(){
        String path = "D:\\编码测试.txt";
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
            Person person = new Person(1, "张三", 24);
            oos.writeObject(person);
            oos.close();

            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)));
            Person o = (Person)ois.readObject();
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printStream(){
        String printPath = "D:\\printStream.txt";
        BufferedInputStream bis = null;
        PrintStream ps = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(path));
            ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(printPath)));
            byte[] bytes = new byte[1024];
            while (bis.read(bytes) != -1){
                ps.println(new String(bytes));
            }
            bis.close();
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







}
