package com.java.study.classloader;

import javax.transaction.Synchronization;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author: cxz
 * @create: 2021/5/24 13:36
 * @description: 自定义类加载器
 **/
public class MyClassloader002 extends ClassLoader  {

    private String classPath;

    public MyClassloader002(String classPath) {
        super();
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = classPath + "\\" + name.replace(".","\\").concat(".class");
        //String path = name.replace(".","\\").concat(".class");
        File file = new File(path);
        if(!file.exists()){
            return null;//没有数据
        }
        FileInputStream fis;
        byte[] b;
        ByteArrayOutputStream baos;
        int read;
        try {
           fis = new FileInputStream(path);
           baos = new ByteArrayOutputStream();
           while ((read = fis.read()) != -1){
               baos.write(read);
           }
           b = baos.toByteArray();
           return this.defineClass(name,b,0,b.length);
        }catch (Exception e){
            throw new ClassNotFoundException("自定义类加载器出现异常");
        }
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> c;
        synchronized (getClassLoadingLock(name)){
            //先从缓存总查找
            c = findLoadedClass(name);
            if(c == null){
                //优先使用自己类加载器
                c = this.findClass(name);
                if(c == null){
                    //使用双亲委派机制
                    c = super.loadClass(name,resolve);
                }
            }
            return c;
        }
    }
}
