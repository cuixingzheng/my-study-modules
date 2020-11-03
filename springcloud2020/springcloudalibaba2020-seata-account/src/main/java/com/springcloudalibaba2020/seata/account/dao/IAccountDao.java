package com.springcloudalibaba2020.seata.account.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface IAccountDao {

    void decrease(@Param(("money")) Integer money);

}
