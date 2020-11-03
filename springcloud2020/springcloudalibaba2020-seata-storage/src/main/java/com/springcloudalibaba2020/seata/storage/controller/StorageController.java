package com.springcloudalibaba2020.seata.storage.controller;

import com.springcloudalibaba2020.seata.storage.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: cxz
 * @create: 2020/10/30 14:14
 * @description:
 **/
@RestController
@RequestMapping("storage")
public class StorageController {

    @Resource
    private StorageService storageService;

    @GetMapping("decrease")
    @ResponseBody
    public String decrease(Integer count){
        storageService.decrease(count);
        return "success storage decrease";
    }
}
