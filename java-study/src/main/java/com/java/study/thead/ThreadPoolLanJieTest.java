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
    }

    public static void countDownLatchTest(){
        ExecutorService pool = Executors.newFixedThreadPool(1);
        CountDownLatch c = new CountDownLatch(5);
        pool.submit(() ->handlerData(c));
        pool.submit(() ->handlerData(c));
        pool.submit(() ->handlerData(c));
        pool.submit(() ->handlerData(c));
        pool.submit(() ->handlerData(c));
        try {
            c.await();
            System.out.println("结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(c.getCount());
        pool.shutdown();
    }

    public static String handlerData(CountDownLatch c){
        System.out.println("执行中。。。");
        c.countDown();
        return null;
    }

    public static void cyclicBarrierTest(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,() -> System.out.println("执行结束"));
        ExecutorService pool = Executors.newFixedThreadPool(5);
        pool.submit(() -> handlerData(cyclicBarrier));
        pool.submit(() -> handlerData(cyclicBarrier));
        pool.submit(() -> handlerData(cyclicBarrier));
        pool.submit(() -> handlerData(cyclicBarrier));
        pool.submit(() -> handlerData(cyclicBarrier));

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
