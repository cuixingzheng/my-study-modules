package com.java.study.algorithm;

import java.util.Arrays;

/**
 * @author: cxz
 * @create: 2021/5/11 19:32
 * @description: 三角形最大周长：
 **/
public class Triangles {
    /**
     * @author: cxz
     * @description: 从输入的整数数组中  返回由其中长度组成的、面积不为零的最大三角形周长
     * 如果不能够组成三角形 返回 0
     */

    public static void main(String[] args) {
        int[] array = {2,3,6,8,11,1,13,4,7,32,5};
        System.out.println(calPerimeter(array));
    }
    //贪心算法，o(nlogn*n)，空间复杂度o(1)排序后 从右侧开始三个边向滑动，三个相邻的值复合三角形规则 即最大三角形周长（如果相邻三个不能组成三角形，则不响铃数据也不能组成三角形）
    public static int calPerimeter(int[] array){
        Arrays.sort(array);
        for (int i = array.length - 1; i >= 2; i--) {
            if(array[i] < array[i-1] + array[i-2]){
                return array[i] + array[i-1] + array[i-2];
            }
        }
        return 0;
    }
}
