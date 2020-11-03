package com.springcloudalibaba2020.seata.account.service;

import com.springcloudalibaba2020.seata.account.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: cxz
 * @create: 2020/10/30 11:49
 * @description:
 **/
@Service
public class AccountService {

    @Autowired
    private IAccountDao iAccountDao;

    public void decrease(Integer money){
        iAccountDao.decrease(money);
    }

}
