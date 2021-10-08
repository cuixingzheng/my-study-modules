package com.java.study.spring.service;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author: cxz
 * @create: 2021/2/1 16:28
 * @description:
 **/

@Service
public class IndexService {

    @EventListener(value = {ApplicationEvent.class})
    private void listen(ApplicationEvent applicationEvent){
        System.out.println("applicationEvent : " + applicationEvent.toString());
    }

//    private UserService userService;
//
//    public UserService getUserService() {
//        return userService;
//    }
//
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    public IndexService(UserService userService) {
//        this.userService = userService;
//    }
}
