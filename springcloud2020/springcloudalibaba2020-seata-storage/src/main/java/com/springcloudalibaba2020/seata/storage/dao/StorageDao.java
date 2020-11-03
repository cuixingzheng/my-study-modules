package com.springcloudalibaba2020.seata.storage.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author: cxz
 * @create: 2020/10/30 14:17
 * @description:
 **/
@Component
public interface StorageDao {

    void decrease(@Param("count") Integer count);

}
