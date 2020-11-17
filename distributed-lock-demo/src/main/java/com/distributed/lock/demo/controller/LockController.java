package com.distributed.lock.demo.controller;

import com.distributed.lock.demo.service.DistributedLockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: cxz
 * @create: 2020/11/4 14:33
 * @description:
 **/
@RestController
public class LockController {

    @Resource
    private DistributedLockService distributedLockService;

    @GetMapping("index")
    @ResponseBody
    public String index(){
        distributedLockService.distributedLockMethod();
        return "index success";
    }
}
