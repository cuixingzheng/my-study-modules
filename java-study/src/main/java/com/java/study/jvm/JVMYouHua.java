package com.java.study.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: cxz
 * @create: 2021/6/3 11:39
 * @description: jvm 调优
 **/
public class JVMYouHua {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //while (true){
            try {
                Thread.sleep(30000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //executorService.submit(() -> addData(list));
        //}
    }

    public static void addData( List<Integer> list){
        Random random = new Random();
        list.add(random.nextInt(10000));
    }


}
