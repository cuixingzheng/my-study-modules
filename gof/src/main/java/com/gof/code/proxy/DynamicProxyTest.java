package com.gof.code.proxy;

import java.lang.reflect.Proxy;

/**
 * @author: cxz
 * @create: 2020/8/11 16:51
 * @description:
 **/
public class DynamicProxyTest {

    public static void main(String[] args) {
        Image realImage = new RealImage();
        Image proxyInstance = (Image)Proxy.newProxyInstance(Image.class.getClassLoader(), new Class[]{Image.class}, new DynamicProxy(realImage));
        proxyInstance.display();
    }
}
