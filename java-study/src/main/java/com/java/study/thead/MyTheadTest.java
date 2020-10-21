package com.java.study.thead;

/**
 * @author: cxz
 * @create: 2020/8/14 10:50
 * @description:
 **/
public class MyTheadTest {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThreadRunnable());
        thread.start();

        Thread thread1 = new MyTheadExtends();
        thread1.start();
    }


    static class MyThreadRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("方法一：实现Runnable接口");
        }
    }

    static class MyTheadExtends extends Thread {
        @Override
        public void run() {
            System.out.println("方法二:继承 Thread");
        }
    }
}
