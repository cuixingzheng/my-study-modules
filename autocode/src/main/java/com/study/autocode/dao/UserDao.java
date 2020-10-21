package com.study.autocode.dao;

import com.study.autocode.po.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: cxz
 * @create: 2020/6/4 15:42
 * @description:
 **/
@Repository
public interface UserDao {

    List<User> selectUsers();
}
