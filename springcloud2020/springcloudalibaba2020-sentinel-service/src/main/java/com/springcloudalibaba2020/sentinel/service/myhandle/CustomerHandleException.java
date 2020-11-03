package com.springcloudalibaba2020.sentinel.service.myhandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: cxz
 * @create: 2020/10/27 14:51
 * @description:
 **/
public class CustomerHandleException {
    public static Map<String,Object> myHandleException001(BlockException blockException){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code",444);
        result.put("msg","降级方法为 ： myHandleException001");
        return result;
    }
}
