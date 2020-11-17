package com.java.study.thead;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: cxz
 * @create: 2020/11/6 16:47
 * @description:
 **/
public class ThreadPoolTest002 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        //Executors.newSingleThreadExecutor()
    }

}
