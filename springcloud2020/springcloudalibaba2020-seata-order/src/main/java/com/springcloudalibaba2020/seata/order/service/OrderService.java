package com.springcloudalibaba2020.seata.order.service;//package com.springcloudalibaba2020.seata.order.service;
//
//import com.springcloudalibaba2020.seata.order.dao.OrderDao;
//import com.springcloudalibaba2020.seata.order.po.OrderPo;
//import org.springframework.beans.factory.annotation.Autowired;
//import com.springcloudalibaba2020.seata.order.dao.OrderDao;
import com.springcloudalibaba2020.seata.order.dao.OrderDao;
import com.springcloudalibaba2020.seata.order.feignService.IAccountService;
import com.springcloudalibaba2020.seata.order.feignService.IStorageService;
import com.springcloudalibaba2020.seata.order.po.OrderPo;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
//
//import javax.annotation.Resource;

/**
 * @author: cxz
 * @create: 2020/10/29 16:33
 * @description:
// **/
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private IStorageService iStorageService;

    @Autowired
    private IAccountService iAccountService;

    @GlobalTransactional
    public void createOrder(OrderPo orderPo){
        //创建订单
        orderDao.createOrder(orderPo);
        //减少库存
        iStorageService.decrease(orderPo.getCount());
        //扣除金额
        iAccountService.decrease(orderPo.getMoney());
        //下单成功
        orderDao.updateOrder(orderPo.getId());
    }

}
