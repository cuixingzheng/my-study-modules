package com.springcloud.provider.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: cxz
 * @create: 2020/9/28 16:23
 * @description:
 **/
@FeignClient(value = "SPRINGCLOUD-PROVIDER")
public interface IProviderFeignClient {

     @PostMapping("provider/myProviderInfo")
     @ResponseBody
     String getProviderInfo();
}

