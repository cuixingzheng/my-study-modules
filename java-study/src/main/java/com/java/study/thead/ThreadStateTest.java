package com.java.study.thead;

/**
 * @author: cxz
 * @create: 2020/8/14 15:13
 * @description:
 **/
public class ThreadStateTest {


    private static ThreadStateTest obj = new ThreadStateTest();


    public static void main(String[] args) {
        new Thread(() ->{
            try {

                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

//        new Thread(() -> {
//            try {
//                obj.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
    }
}
