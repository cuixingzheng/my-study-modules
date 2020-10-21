package com.gof.code.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: cxz
 * @create: 2020/8/11 16:46
 * @description:
 **/
public class DynamicProxy implements InvocationHandler {

    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前");
        Object result = method.invoke(object, args);
        System.out.println("代理后");
        return result;
    }
}
