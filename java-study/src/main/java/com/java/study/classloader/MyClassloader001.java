package com.java.study.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

/**
 * @author: cxz
 * @create: 2021/5/24 13:36
 * @description: 自定义类加载器
 **/
public class MyClassloader001 extends ClassLoader  {

    private String classPath;

    public MyClassloader001(String classPath) {
        super();
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //name = name.substring(0,name.lastIndexOf(".")) + ".SalaryCaler";
        String path = classPath + "\\" + name.replace(".","\\").concat(".class");
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
    public Class<?> loadClass(String name) throws ClassNotFoundException {
//        if(name.startsWith("com.java.study")){
//            return findClass(name);
//        }
        return super.loadClass(name);
    }
}
