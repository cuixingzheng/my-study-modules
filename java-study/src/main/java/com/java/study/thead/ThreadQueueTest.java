package com.java.study.thead;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: cxz
 * @create: 2020/9/3 16:21
 * @description:
 **/
public class ThreadQueueTest {

    private static List<ThreadPoolTaskExecutor> poolList;
    private static List<ThreadPoolExecutor> poolList002;

    static {
        poolList = new ArrayList<>();
        for(int i=0;i<2;i++){
            ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
            threadPoolTaskExecutor.setMaxPoolSize(9);
            threadPoolTaskExecutor.setCorePoolSize(3);
            threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
            threadPoolTaskExecutor.initialize();
            poolList.add(threadPoolTaskExecutor);
        }
    }

    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue  = new ConcurrentLinkedQueue<>();
        for(int i=0;i<10;i++){
            queue.add("queue_" + i);
        }
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                ThreadPoolTaskExecutor threadPool = getThreadPool();
                if(threadPool != null){
                    String peek = queue.poll();
                    if(peek != null){
                        threadPool.submit(() -> handler(threadPool,peek));
                    }
                }




                ListenableFuture<?> listenableFuture = threadPool.submitListenable(() -> handler(threadPool, ""));

                listenableFuture.addCallback(new ListenableFutureCallback<Object>() {
                    @Override
                    public void onSuccess(Object o) {
                        System.out.println(o);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {

                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    private static ThreadPoolTaskExecutor getThreadPool(){
        for (ThreadPoolTaskExecutor service : poolList){
            if(service.getActiveCount() <= 0)
                return service;
        }
        return null;
    }

    private static void handler(ThreadPoolTaskExecutor pool,String taskUUid){
        System.out.println("执行任务");
    }

}
