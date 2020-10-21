package com.springcloud.provider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: cxz
 * @create: 2020/9/24 11:14
 * @description:
 **/
@Controller
@RequestMapping("")
public class ProviderController {

    @PostMapping(value = "index")
    @ResponseBody
    public Map<String,Object> index(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("msg","my is provider");
        return map;
    }
}
