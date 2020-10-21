package com.springcloud2020.order.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: cxz
 * @create: 2020/9/30 16:29
 * @description:
 **/
@Component
public class MyRandomLoadBalance implements ILoadBalance {

    private AtomicInteger counter = new AtomicInteger(0);

    public ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstances) {
        if(serviceInstances == null || serviceInstances.size() == 0){
            return null;
        }
        int increment = getAndIncrement();
        return serviceInstances.get(increment%serviceInstances.size());
    }

    private int getAndIncrement(){
        int current;
        int next;
        do {
            current = counter.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!counter.compareAndSet(current, next));
        return next;
    }
}
