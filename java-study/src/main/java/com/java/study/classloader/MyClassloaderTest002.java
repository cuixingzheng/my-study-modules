package com.java.study.classloader;

import java.lang.reflect.InvocationTargetException;

/**
 * @author: cxz
 * @create: 2021/5/24 13:36
 * @description: 自定义类加载器
 **/
public class MyClassloaderTest002 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        MyClassloader002 myClassloader = new MyClassloader002("D:\\idea_workspace002\\my-study-modules\\java-study\\target\\classes");
        //Class<?> aClass = myClassloader.loadClass("com.java.study.classloader.SalaryCaler");
        System.out.println(calSalary(1000D,myClassloader));
    }

    public static Double calSalary(Double salary,ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = classLoader.loadClass("com.java.study.classloader.SalaryCaler");
        System.out.println("类加载器 ： " + aClass.getClassLoader());
        Object newInstance = aClass.newInstance();
        return (Double)aClass.getMethod("cal",Double.class).invoke(newInstance,salary);
    }
}
