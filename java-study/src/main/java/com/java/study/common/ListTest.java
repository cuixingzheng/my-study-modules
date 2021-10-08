package com.java.study.common;

import java.util.*;

/**
 * @author: cxz
 * @create: 2021/9/8 10:24
 * @description:
 **/
public class ListTest {


    public static void main(String[] args) {
        //Collection<Integer> integers = Collections.synchronizedCollection(new ArrayList<Integer>());
        //new HashSet<Integer>();
        //new TreeSet<Integer>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1",1);


        TreeMap<Object, Object> treeMap = new TreeMap<>();
        //HashMap<String, Integer> map1 = new HashMap<>(16);
        treeMap.put("d","d");

        LinkedList<Integer> integers = new LinkedList<>();

        Hashtable<Object, Object> hashtable = new Hashtable<>();

        String dd = "ddd";
        dd.intern()
    }
}
