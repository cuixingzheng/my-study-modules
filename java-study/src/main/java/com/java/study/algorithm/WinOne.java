package com.java.study.algorithm;

/**
 * @author: cxz
 * @create: 2021/5/14 15:33
 * @description: 预测赢家
 **/
public class WinOne {
    public static void main(String[] args) {
        int[] array  = {5,200,1,3,6};
        int maxScore = getMaxScore(array, 0, array.length-1);
        System.out.println("maxScore = " + maxScore);
        int sum = 0;
        for (int i : array){
            sum += i;
        }
        System.out.println(maxScore > sum - maxScore);

        //System.out.println(getMaxScore1(array, 0, array.length - 1));


    }
    //递归一：（求和）
    public static int getMaxScore(int[] array,int l,int r){
        if(l == r){
            //如果相等时直接返回
            return array[l];
        }
        int lSum = 0;
        int rSum = 0;
        if(r - l == 1){
            lSum = array[l];
            rSum = array[r];
        }
        if(r - l >= 2){
//            lSum = array[l] + Math.min(getMaxScore(array,l+2,r),getMaxScore(array,l+1,r-1));//选择左侧值
//            rSum = array[r] + Math.min(getMaxScore(array,l+1,r-1),getMaxScore(array,l,r-2));//选择右侧值
            //优化后(减少递归次数)
            int temp = getMaxScore(array,l+1,r-1);
            lSum = array[l] + Math.min(getMaxScore(array,l+2,r),temp);//选择左侧值
            rSum = array[r] + Math.min(temp,getMaxScore(array,l,r-2));//选择右侧值
        }
        return Math.max(lSum,rSum);
    }

    //递归：求差值,为正数则赢，负数则输
    public static int getMaxScore1(int[] array,int l,int r){
        if(l == r){
            //如果相等时直接返回
            return array[l];
        }
        int lSum = array[l] - getMaxScore1(array,l+1,r);//选择左侧时计算差值
        int rSum = array[r] - getMaxScore1(array,l,r-1);//选择右侧时计算差值
        return Math.max(lSum,rSum);
    }
}
