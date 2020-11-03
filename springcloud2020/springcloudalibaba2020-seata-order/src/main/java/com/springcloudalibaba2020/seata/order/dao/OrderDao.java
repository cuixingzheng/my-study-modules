package com.springcloudalibaba2020.seata.order.dao;

import com.springcloudalibaba2020.seata.order.po.OrderPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: cxz
 * @create: 2020/10/29 16:33
 * @description:
 **/
@Repository
public interface OrderDao {

    int createOrder(OrderPo orderPo);

    void updateOrder(@Param("id") Integer id);
}
