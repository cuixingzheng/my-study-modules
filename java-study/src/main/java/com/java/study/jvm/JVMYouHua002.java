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
public class JVMYouHua002 {
    public static void main(String[] args) {
        while (true){
            main002(args);
        }

    }
    public static void main002(String[] args) {
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
