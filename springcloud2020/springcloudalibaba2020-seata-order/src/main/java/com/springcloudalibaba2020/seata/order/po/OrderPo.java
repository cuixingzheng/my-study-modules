package com.springcloudalibaba2020.seata.order.po;

/**
 * @author: cxz
 * @create: 2020/10/29 16:33
 * @description:
 **/
public class OrderPo {

    public OrderPo() {
    }

    public OrderPo(String userId, String commodityCode, Integer count, Integer money, Integer status) {
        this.userId = userId;
        this.commodityCode = commodityCode;
        this.count = count;
        this.money = money;
        this.status = status;
    }

    private Integer id;

    private String userId;

    private String commodityCode;

    private Integer count;

    private Integer money;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
