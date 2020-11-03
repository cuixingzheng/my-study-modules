package com.springcloudalibaba2020.sentinel.service.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloudalibaba2020.sentinel.service.myhandle.CustomerHandleException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: cxz
 * @create: 2020/10/27 13:55
 * @description:
 **/
@RestController
public class RateLimitController {

    @GetMapping(value = "/byResource")
    @ResponseBody
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public Map<String,Object> byResource(){
        return responseMap(200,"正常限流OK");
    }

    @GetMapping(value = "/byUrl")
    @ResponseBody
    @SentinelResource(value = "byUrl")
    public Map<String,Object> byUrl(){
        return responseMap(200,"方法名：byUrl,正常限流OK");
    }

    public Map<String,Object> handleException(BlockException blockException){
        return responseMap(444,blockException.getClass().getCanonicalName());
    }

    public Map<String,Object> responseMap(Integer code,String msg){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",code);
        result.put("msg",msg);
        return result;
    }



    @GetMapping(value = "/customerBlockHandler")
    @ResponseBody
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerHandleException.class,
            blockHandler = "myHandleException001")
    public Map<String,Object> customerBlockHandler(){
        return responseMap(200,"客户自定义限流OK");
    }





}
