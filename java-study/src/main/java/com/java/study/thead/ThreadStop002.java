package com.java.study.thead;

/**
 * @author: cxz
 * @create: 2020/8/19 10:23
 * @description:
 **/
public class ThreadStop002 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (true)
                System.out.println(++i);
        });
        thread.start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
    }
}
