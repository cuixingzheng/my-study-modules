package com.springcloudalibaba2020.seata.account.controller;

import com.springcloudalibaba2020.seata.account.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: cxz
 * @create: 2020/10/30 11:43
 * @description:
 **/
@RestController
@RequestMapping("account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping("decrease")
    @ResponseBody
    public String decrease(Integer money){
        throw new NullPointerException("account null");
        //accountService.decrease(money);
        //return "decrease success";
    }
}
