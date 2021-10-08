package com.java.study.algorithm;

/**
 * @author: cxz
 * @create: 2021/5/7 16:27
 * @description: 求出根号x的整数部分
 **/
public class SqrtX {

    public static void main(String[] args) {
        System.out.println(twoSearch((23)));
        System.out.println(newTon((25)));
    }

    //二分法查找
    public static int twoSearch(int x){
        int index = -1;
        int l=0;
        int r=x;
        while (l<=r){//两个指针重叠是结束
            int mid = l + (r-l)/2;
            if(mid*mid <=x){//如果中间值小于等于x,将mid赋值给index，l需要向右移动，
                index = mid;
                l = mid +1;
            }else {
                r = mid -1;//如果中间值大约x，将r向左移动
            }
        }
        return index;
    }

    //牛顿迭代（迭代）
    public static int newTon(int x){
        return (int)sqrt(10,x);//10任意取，取的值越接近所求的值，算法越快
    }

    public static double sqrt(double i,int x){
        double res = (i + x/i)/2;//求均值
        if(i == res){//如果此时均值与i相等，则此时i收敛，即 i = x/i,满足i的平方等于x
            return i;//此时的i是double值，最大精度满足double精度
        }else {
            return sqrt(res,x);//如果不相等，继续寻找
        }
    }
}
