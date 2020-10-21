package com.springcloud2020.feign.config;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface ILoadBalance {

    /**
     * @author: cxz
     * @create: 2020/9/30 16:28
     * @param:  []
     * @return: org.springframework.cloud.client.ServiceInstance
     * @description: 负载均衡接口
     **/
    ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstances);
}
