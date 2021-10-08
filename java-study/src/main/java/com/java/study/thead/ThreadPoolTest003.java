package com.java.study.thead;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: cxz
 * @create: 2020/11/6 16:47
 * @description: 判断线程池中任务全部执行完毕
 **/
public class ThreadPoolTest003 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(ThreadPoolTest003::printData);
        executorService.submit(ThreadPoolTest003::printData);
        executorService.shutdown();
        while (true){
            if(executorService.isTerminated()){
                System.out.println("executorService is end");
                break;
            }
            Thread.sleep(100L);
        }
        //System.out.println(executorService.awaitTermination(50, TimeUnit.SECONDS));
        //executorService.submit(ThreadPoolTest002::printData);
        //executorService.shutdown();
    }

    public static void printData(){
        try {
            Thread.sleep(5000L);
            System.out.println("thread name is " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
