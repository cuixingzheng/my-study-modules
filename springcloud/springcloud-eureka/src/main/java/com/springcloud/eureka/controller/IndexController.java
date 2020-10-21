package com.springcloud.eureka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: cxz
 * @create: 2020/9/24 11:14
 * @description:
 **/
@Controller
@RequestMapping("")
public class IndexController {

    @PostMapping(value = "index")
    @ResponseBody
    public String index(){
        return "my is eureka";
    }
}
