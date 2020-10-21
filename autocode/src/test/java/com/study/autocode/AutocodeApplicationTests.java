package com.study.autocode;

import com.study.autocode.dao.UserDao;
import com.study.autocode.po.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest(classes = AutocodeApplication.class)
@RunWith(value = SpringJUnit4ClassRunner.class)
public class AutocodeApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {
        List<User> users = userDao.selectUsers();
        System.out.println(users);
    }

}
