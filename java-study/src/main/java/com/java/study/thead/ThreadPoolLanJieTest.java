package com.java.study.thead;

import java.util.concurrent.*;

/**
 * @author: cxz
 * @create: 2020/9/8 17:40
 * @description:
 **/
public class ThreadPoolLanJieTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        cyclicBarrierTest();
        //countDownLatchTest();
    }

    public static void countDownLatchTest(){
        ExecutorService pool = Executors.newFixedThreadPool(1);
        int size = 5;
        //注意要求放入到线程池的任务与CountDownLatch数量相同
        CountDownLatch c = new CountDownLatch(size);
        for (int i = 0; i < size; i++) {
            pool.submit(() ->handlerData(c));
        }
        try {
            c.await();
            System.out.println("结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }

    public static String handlerData(CountDownLatch c){
        System.out.println("执行中。。。");
        c.countDown();
        return null;
    }

    public static void cyclicBarrierTest(){
        int size = 2;
        //声明一个栅栏
        CyclicBarrier cyclicBarrier = new CyclicBarrier(size,() -> System.out.println("执行结束"));
        ExecutorService pool = Executors.newFixedThreadPool(size);
        for (int i = 0; i < size; i++) {
            pool.submit(() ->handlerData(cyclicBarrier));
        }
        //System.out.println("主线程执行");
        pool.shutdown();
    }

    public static String handlerData(CyclicBarrier c) throws BrokenBarrierException, InterruptedException {
        System.out.println("执行中。。。");
        c.await();
        return null;
    }

    public static String handlerData002() {
       Integer i = 1;
        //System.out.println(i instanceof Integer);
        System.out.println(null instanceof Object);
        return null;
    }

}
