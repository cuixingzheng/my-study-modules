package com.springcloudalibaba2020.sentinel.service.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.*;

/**
 * @author: cxz
 * @create: 2020/10/26 14:35
 * @description:
 **/
@RestController
@RequestMapping("sentinel")
public class SentinelController {

    @GetMapping("getInfoA")
    @ResponseBody
    public String getInfoA() {
        return "success A";
    }

    @ResponseBody
    @GetMapping("getInfoB")
    public String getInfoB() {
        System.out.println(Thread.currentThread().getName() + "\t" + ".... testB");
        return "success B";
    }

    @ResponseBody
    @GetMapping("getInfoC")
    public String getInfoC() {
        //System.out.println(Thread.currentThread().getName() + "\t" + ".... testB");
        int a = 10/0;
        return "success C";
    }

    @ResponseBody
    @GetMapping("getInfoD")
    public String getInfoD() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success D";
    }

    @ResponseBody
    @GetMapping("testHostKey")
    @SentinelResource(value = "testHostKey",blockHandler = "deal_testHostKey")
    public String testHostKey(@RequestParam(value = "p1",required = false)String p1,
                              @RequestParam(value = "p2",required = false)String p2
                              ) {

        return "testHostKey";
    }

    public String deal_testHostKey(String p1, String p2, BlockException blockException) {
        return "deal_testHostKey";
    }


}
