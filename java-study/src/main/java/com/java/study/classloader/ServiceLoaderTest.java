package com.java.study.classloader;

import com.java.study.classloader.spi.SalaryCalerService;

import java.util.ServiceLoader;

/**
 * @author: cxz
 * @create: 2021/5/31 17:59
 * @description: java SPI
 **/
public class ServiceLoaderTest {

    public static void main(String[] args) {
        MyClassloader001 myClassloader = new MyClassloader001("D:\\idea_workspace002\\my-study-modules\\java-study\\target\\classes");
        ServiceLoader<SalaryCalerService> services = ServiceLoader.load(SalaryCalerService.class,myClassloader);
    }
}
