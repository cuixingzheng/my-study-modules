package com.java.study.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: cxz
 * @create: 2021/5/8 10:15
 * @description: 从数组中找出两个数之和等于target,找到后返回下标值数组
 **/
public class TwoNumberSum {


    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6};
        System.out.println(JSON.toJSONString(solution(ints, 10)));
        System.out.println(JSON.toJSONString(solution002(ints, 10)));
    }

    //暴力算法 时间复杂度o(n平方) 空间复杂度o(1)
    public static int[] solution(int[] array,int target){
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] + array[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1};
    }

    //map方式 时间复杂度o(n),空间复杂度o(n),以空间换时间
    public static int[] solution002(int[] array,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
           if(map.containsKey(target-array[i])){
               return new int[]{map.get(target-array[i]),i};
           }
            map.put(array[i],i);
        }
        return new int[]{-1};
    }


}
