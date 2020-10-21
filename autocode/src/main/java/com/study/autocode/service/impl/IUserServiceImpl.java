package com.study.autocode.service.impl;

import com.study.autocode.dao.UserDao;
import com.study.autocode.po.User;
import com.study.autocode.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: cxz
 * @create: 2020/6/4 16:29
 * @description:
 **/
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectUsers() {
        return userDao.selectUsers();
    }

}
