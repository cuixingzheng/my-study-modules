package com.java.study.proxy.dynamic.cglib;

import com.java.study.proxy.dynamic.jdk.IUserService;

/**
 * @author: cxz
 * @create: 2020/11/17 16:28
 * @description:
 **/
public class TestDynamicProxy {

    public static void main(String[] args) {
        UserService userService = new UserService();
        ProxyFactory proxyFactory = new ProxyFactory(userService);

        UserService proxyInstance = (UserService)proxyFactory.getProxyInstance();
        proxyInstance.save();
    }

}
