package com.java.study.collection;

import java.util.*;

/**
 * @author: cxz
 * @create: 2020/9/8 10:13
 * @description:
 **/
public class ListTest {

    public static void main(String[] args) {
//        List<Integer> aList = new ArrayList<>();
//        List<Integer> lList = new LinkedList<>();
//        for (int i=0;i<100;i++){
//            int random = (int) (Math.random() * 1000);
//            aList.add(random);
//            lList.add(random);
//        }
//        long begin = System.currentTimeMillis();
//        aList.forEach(Object::hashCode);
//        System.out.println("Time is " + (System.currentTimeMillis()-begin));
//
//        Map<String,Integer> map = new HashMap<>();


//        Set<Integer> set = new HashSet<>();
//        set.add(null);
//        System.out.println(set.size());
//
//        Set<Integer> set02 = new TreeSet<>();
//        set02.add(null);
//        System.out.println(set02.size());

//        Set<Integer> set03 = new LinkedHashSet<>();
//        set03.add(null);
//        System.out.println(set03.size());


        Collections.synchronizedSet(new HashSet<>());
    }
}
