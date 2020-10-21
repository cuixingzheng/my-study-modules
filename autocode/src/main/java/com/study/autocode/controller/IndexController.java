package com.study.autocode.controller;

import com.alibaba.fastjson.JSON;
import com.study.autocode.dao.UserDao;
import com.study.autocode.po.User;
import com.study.autocode.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: cxz
 * @create: 2020/6/4 13:58
 * @description:
 **/
@Controller
public class IndexController {

    @Autowired
    private IUserService iUserService;




    @RequestMapping(value = "index",method = RequestMethod.POST)
    @ResponseBody
    public String index(){
//        List<User> users = iUserService.selectUsers();
//        System.out.println(JSON.toJSONString(users));

        return "index";
    }
}
