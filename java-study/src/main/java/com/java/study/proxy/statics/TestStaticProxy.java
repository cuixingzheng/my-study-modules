package com.java.study.proxy.statics;

/**
 * @author: cxz
 * @create: 2020/11/17 16:06
 * @description:
 **/
public class TestStaticProxy {
    public static void main(String[] args) {
        IUserService iUserService = new UserService();
        StaticProxy proxy = new StaticProxy(iUserService);
        proxy.save();
    }

}
