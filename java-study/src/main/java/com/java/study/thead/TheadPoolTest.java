package com.java.study.thead;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author: cxz
 * @create: 2020/8/14 14:02
 * @description:
 **/
public class TheadPoolTest {

    public static void main (String[] args) throws Exception{
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("线程池：Runnable 接口使用");
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });
        System.out.println("线程池：Callable 接口使用，future接收数据");
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 2;
            }
        });
        System.out.println(future.get());

        System.out.println("线程池：Callable 接口使用，批量执行任务,List<Future>接收数据");
        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(() ->3);
        tasks.add(() ->4);
        List<Future<Integer>> futures = executorService.invokeAll(tasks);
        futures.stream().map(o -> {
                try {
                    return o.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                return null;
            }).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("线程池:Callable 接口使用，使用Callable实例化FutureTask，FutureTask是任务也是接收数据对象");
        FutureTask<Integer> futureTask = new FutureTask<>(() -> 5);
        executorService.submit(futureTask);
        System.out.println(futureTask.get());

        executorService.shutdown();


    }
}
