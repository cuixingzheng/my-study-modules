package com.java.study.classloader.spi;

import com.java.study.classloader.MyClassloader001;
import com.java.study.classloader.SalaryCaler;

import java.lang.reflect.InvocationTargetException;
import java.util.ServiceLoader;

/**
 * @author: cxz
 * @create: 2021/5/24 13:36
 * @description: 自定义类加载器
 **/
public class MyClassloaderTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
       // MyClassloader myClassloader = new MyClassloader("D:\\idea_workspace002\\my-study-modules\\java-study\\target\\classes");
//        SalaryCaler salaryCaler001 = new SalaryCaler();
//        System.out.println(salaryCaler001.cal(1000D));
//        System.out.println("=======================");
        MyClassloader001 myClassloader = new MyClassloader001("D:\\idea_workspace002\\my-study-modules\\gof\\target\\classes");
        ServiceLoader<SalaryCalerService> services = ServiceLoader.load(SalaryCalerService.class,myClassloader);
        //Class<?> aClass = myClassloader.loadClass("com.java.study.classloader.SalaryCaler");
//        Object object = aClass.newInstance();
//        SalaryCaler salaryCaler002 = (SalaryCaler)object;
//        System.out.println(salaryCaler002.cal(1000D));
//        while (true){
//            System.out.println(calSalary(1000D, myClassloader));
//            try {
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public static Double calSalary(Double salary,ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = classLoader.loadClass("com.java.study.classloader.SalaryCaler");
        System.out.println("类加载器 ： " + aClass.getClassLoader());
        Object newInstance = aClass.newInstance();
        return (Double)aClass.getMethod("cal",Double.class).invoke(newInstance,salary);
    }
}
