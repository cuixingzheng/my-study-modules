package com.java.study.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: cxz
 * @create: 2020/11/6 11:38
 * @description:
 **/
public class MapUtil {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("key",001);
        System.out.println(map.put("key002", 002));
        System.out.println();
        map.get("key");
        //map.hashCode()


        int a  = 6;
        System.out.println((a=3) == 3);
    }
}
