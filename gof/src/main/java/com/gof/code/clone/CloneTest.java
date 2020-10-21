package com.gof.code.clone;

import java.io.*;

/**
 * @author: cxz
 * @create: 2020/8/5 18:56
 * @description:
 **/
public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
//
//        Score score = new Score("数学",90);
//        User user = new User(1,"张三",score);
//        User clone = (User) user.clone();
//        System.out.println("克隆前： " + user );
//        System.out.println("克隆后： " + clone );
//        user.getScore().setScore(60);
//        System.out.println("修改后克隆前： " + user );
//
//
//        System.out.println("修改后克隆后： " + clone );





        try {
            Score score = new Score("数学",90);
                    int[] items = {1,5,10};
            User user = new User(1,"张三",score,items);

            //声明一个字节数组输出缓冲区
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            //创建序列化输出流
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            //将对象序列化到数组输出缓冲区中
            oos.writeObject(user);
            //声明一个字节数组输入缓冲区
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            //创建序列化输入流
            ObjectInputStream ois = new ObjectInputStream(bais);
            //将数据反序列化到对象中
            User clone = (User) ois.readObject();

            System.out.println("克隆前： " + user);
            System.out.println("克隆后： " + clone);
            user.getScore().setScore(60);
            user.getItems()[0] = 2;
            System.out.println("修改后克隆前： " + user);
            System.out.println("修改后克隆后： " + clone);

            baos.close();
            oos.close();;
            bais.close();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        Score score = new Score("数学",90);
//        int[] items = {1,5,10};
//        User user = new User(1,"张三",score,items);
//        User clone = (User) user.clone();
//        System.out.println("克隆前： " + user );
//        System.out.println("克隆后： " + clone );
//        //user.getScore().setScore(60);
//        user.getItems()[0] = 2;
//        System.out.println("修改后克隆前： " + user );
//        System.out.println("修改后克隆后： " + clone );
    }
}
