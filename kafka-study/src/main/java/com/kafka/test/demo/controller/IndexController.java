package com.kafka.test.demo.controller;

import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "index")
    @ResponseBody
    public String index(){
        return "index";
    }
}
