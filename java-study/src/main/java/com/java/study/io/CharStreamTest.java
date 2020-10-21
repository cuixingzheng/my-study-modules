package com.java.study.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author: cxz
 * @create: 2020/8/28 15:09
 * @description:
 **/
public class CharStreamTest {

    private static String path = "D:\\编码测试.txt" ;

    public static void main(String[] args) {
        //fileChar();
        //bufferedChar();
        //charArrayChar();
        //transformStream();
        printWrite();
    }
    private static void fileChar(){
        String info = "文件字符流";
        try {
            FileWriter fw = new FileWriter(new File(path));
            FileReader fr = new FileReader(new File(path));
            //这个地方简单介绍下写的编码方式
            //写的时候
            fw.write(info);
            fw.close();
            int read;
            char[] chars = new char[1024];
            int i=0;
            while ((read=fr.read()) !=-1){
               chars[i] = (char) read;
               i++;
            }
            System.out.println(new String(chars));
//            FileInputStream fis = new FileInputStream(new File(path));
//            int read002;
//            byte[] bytes = new byte[1024];
//            int j=0;
//            while ((read002=fis.read()) !=-1){
//                bytes[j] = (byte) read002;
//                j++;
//            }
//            System.out.println(new String(bytes));
//            fis.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferedChar(){
        String info = "文件字符缓冲流";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            //这个地方简单介绍下写的编码方式
            //写的时候
            bw.write(info);
            bw.close();//关闭时，肯定会将数据写入文件
            int read;
            char[] chars = new char[1024];
            int i=0;
            while ((read=br.read()) !=-1){
                chars[i] = (char) read;
                i++;
            }
            System.out.println(new String(chars));
            //bw.close(); 如果此时关闭，无法读取到数据，因为使用字符缓冲流，没有达到指定缓存大小还没有写入文件
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void charArrayChar(){
        String info = "字符数组缓冲流";
        try {
            CharArrayWriter caw = new CharArrayWriter();
            for(int i=0;i<info.length();i++){
                caw.write(info.charAt(i));
            }
            CharArrayReader car = new CharArrayReader(caw.toCharArray());
            int j = 0;
            int read;
            char[] chars = new char[1024];
            while ((read=car.read()) != -1){
                chars[j] = (char) read;
                j++;
            }
            System.out.println(new String(chars));
            caw.close();
            car.close();
        }catch (IOException e){
            e.getStackTrace();
        }
    }

    private static void transformStream(){
        String info = "字符字节转换流";
        try {
            //使用指定字符集将字符流转成字节流
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File(path)), StandardCharsets.UTF_8);
            for(int i=0;i<info.length();i++){
                osw.write(info.charAt(i));
            }
            osw.close();
            //使用指定字符集将字节流转换成字符流
            InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(path)),StandardCharsets.UTF_8);
            int j = 0;
            int read;
            char[] chars = new char[1024];
            while ((read=isr.read()) != -1){
                chars[j] = (char) read;
                j++;
            }
            isr.close();
            System.out.println(new String(chars));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printWrite(){
        String info = "字符打印流";
        try {
            //使用指定字符集将字节流转换成字符流 目的是按指定字符集对字节流解码
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),StandardCharsets.UTF_8));
            //使用指定字符集将字符流转成字节流 目的是按指定字符集对字符流编码
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("D:\\转换流.txt")), StandardCharsets.UTF_8));
            String line;
            while ((line=br.readLine()) != null){
                System.out.println(line);
                pw.println(line);
            }
            br.close();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
