package com.java.study.algorithm;

/**
 * @author: cxz
 * @create: 2021/5/14 18:31
 * @description: 香槟塔：行号和被子数相同，第一行有一个杯子，第二行两个杯子等等，杯子满了之后会均匀流入下面两个杯子
 * 设计有一个函数，倒入cups个杯水，问第row行，第column有多少水
 **/
public class ChampagneTower {

    public static void main(String[] args) {
        System.out.println(getChampagneTower(5, 2, 2));
    }

    public static double getChampagneTower(int cups,int row,int column){
        //创建一个香槟塔二维数组
        double[][] ac = new double[100][100];
        //初始化第一行值
        ac[0][0] = cups;
        for (int r = 0; r < ac.length; r++) {//遍历每一行
            for (int c = 0; c <= r; c++) {//遍历每一列
                double d = (ac[r][c] - 1.0) / 2;
                if(d > 0){//此时溢出
                    ac[r+1][c] += d;//溢出到左侧杯子的量
                    ac[r+1][c+1] += d;//溢出到右侧杯子的量
                }
            }
        }
        return Math.min(ac[row][column],1);
    }


}
