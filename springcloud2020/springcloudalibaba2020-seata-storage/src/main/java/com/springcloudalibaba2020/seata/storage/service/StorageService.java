package com.springcloudalibaba2020.seata.storage.service;

import com.springcloudalibaba2020.seata.storage.dao.StorageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: cxz
 * @create: 2020/10/30 14:16
 * @description:
 **/
@Service
public class StorageService {

    @Autowired
    private StorageDao storageDao;

    public void decrease(Integer count){
        storageDao.decrease(count);
    }
}
