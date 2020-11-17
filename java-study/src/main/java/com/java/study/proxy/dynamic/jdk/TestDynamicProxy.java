package com.java.study.proxy.dynamic.jdk;

/**
 * @author: cxz
 * @create: 2020/11/17 16:28
 * @description:
 **/
public class TestDynamicProxy {

    public static void main(String[] args) {
        IUserService iUserService = new UserService();
        ProxyFactory proxyFactory = new ProxyFactory(iUserService);
        IUserService proxy = (IUserService)proxyFactory.getProxyInstance();
        proxy.save();
    }

}
