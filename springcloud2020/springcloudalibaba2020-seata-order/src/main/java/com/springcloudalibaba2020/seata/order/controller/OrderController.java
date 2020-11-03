package com.springcloudalibaba2020.seata.order.controller;

//import com.springcloudalibaba2020.seata.order.po.OrderPo;
import com.springcloudalibaba2020.seata.order.po.OrderPo;
import com.springcloudalibaba2020.seata.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: cxz
 * @create: 2020/10/29 16:55
 * @description:
 **/
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("createOrder")
    @ResponseBody
    public String createOrder(){
        OrderPo orderPo = new OrderPo("10000", "iphone12", 2, 100, 0);
        orderService.createOrder(orderPo);
        return "创建订单成功";
    }



//    @GetMapping("testOrder")
//    @ResponseBody
//    public String testOrder(){
//        orderService.testOrder();
//        return "创建testOrder订单成功";
//    }


}
