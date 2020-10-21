package com.java.study.thead;

/**
 * @author: cxz
 * @create: 2020/8/17 18:46
 * @description:
 **/
public class ThreadBlocked002 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> new ThreadBlocked002().threadJoin());
        thread.start();
        System.out.println("主线程开始");
        Thread main = Thread.currentThread();//主线程实例
        new Thread(() ->{
            try {
                Thread.sleep(1000L);//当前线程睡眠1秒，让其进入thread.join内
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            main.interrupt();
        }).start();
        long begin = System.currentTimeMillis();
        try {
            thread.join(2000L);//当不设置时间时，等待thread执行完或死亡
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("InterruptedException");
        }
        System.out.println("主线程结束");
        long end = System.currentTimeMillis();
        System.out.println("join 总用时：" + (end-begin));
    }
    public void threadJoin(){
        try {
            Thread.sleep(2000L);
            System.out.println("join 线程运行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
