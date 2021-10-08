package com.java.study.proxy.dynamic.jdk;

import org.springframework.stereotype.Service;

/**
 * @author: cxz
 * @create: 2020/11/17 16:00
 * @description:
 **/
@Service
public class UserService implements IUserService {
    @Override
    public void save() {
        System.out.println("添加用户");
    }
}
