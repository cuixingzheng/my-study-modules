package com.springcloudalibaba2020.seata.order.feignService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient("springcloudalibaba2020-seata-account")
public interface IAccountService {


    @GetMapping("account/decrease")
    String decrease(@RequestParam("money")Integer money);
}
