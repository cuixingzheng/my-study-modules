package com.java.study.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: cxz
 * @create: 2020/9/8 11:47
 * @description:
 **/
public class MapTest {

    public static void main(String[] args) {
        Map<String,Integer> map = new TreeMap<>();
        map.put("dd",null);
        map.put("cc",null);
        System.out.println(map.entrySet().size());


//        Map<String,Integer> map002 = new Hashtable<>();
//        map002.put(null,1);
//        System.out.println(map002.entrySet().size());
//
        Map<String,Integer> map3 = new ConcurrentHashMap<>();
        map3.put("dd",null);
        System.out.println(map3.entrySet().size());

        Map<String, Integer> map006 = Collections.synchronizedMap(new HashMap<>());
        map006.put("dd",null);
        System.out.println(map006.entrySet().size());

    }
}
