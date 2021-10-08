package com.java.study.thead;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: cxz
 * @create: 2020/11/6 16:47
 * @description: Semaphore类属于synchronized升级版，synchronized要求代码块同一时刻只能有一个线程执行，而Semaphore可以代码块同一时刻线程可以执行数量
 **/
public class ThreadPoolSemaphoreTest {

    private static Semaphore semaphore = new Semaphore(2);

    public  static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.submit(ThreadPoolSemaphoreTest::printData);
        }
        executorService.shutdown();
    }

    public static void printData(){
        try {
            semaphore.acquire();
            System.out.println("thread name " + Thread.currentThread().getName() + " begin");
            Thread.sleep(5000L);
            System.out.println("thread name " + Thread.currentThread().getName() + " end");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
