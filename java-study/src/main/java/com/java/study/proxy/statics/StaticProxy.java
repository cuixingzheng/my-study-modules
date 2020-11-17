package com.java.study.proxy.statics;

/**
 * @author: cxz
 * @create: 2020/11/17 15:19
 * @description:
 **/
public class StaticProxy implements IUserService {

    private IUserService iUserService;

    public StaticProxy(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @Override
    public void save() {
        System.out.println("代理对象执行方法。。。0");
        iUserService.save();
    }
}
