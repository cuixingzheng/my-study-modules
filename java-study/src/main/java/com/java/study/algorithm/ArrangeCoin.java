package com.java.study.algorithm;

/**
 * @author: cxz
 * @create: 2021/5/10 14:32
 * @description: 排列硬币： 总共n枚硬币，将它们排列成阶梯形状，要求第k行正好必要有k个硬币，问能排列多少行
 **/
public class ArrangeCoin {

    public static void main(String[] args) {
        int num = 7;
        //System.out.println(arrange(num));
        System.out.println(arrange002(num));
        //System.out.println(arrange003(num));
    }

    //暴力法 （迭代） 时间复杂度o(n) 空间复杂度o(1)
    public static int arrange(int n){
        if( n== 1){
            return 1;
        }
        int m = n;
        for (int i = 1; i <=n; i++) {
            m = m - i;
            if(m<=i){
                return i;
            }
        }
        return -1;
    }

    //二分查找 时间复杂度o(logn) 空间复杂度o(1)
    public static int arrange002(int n){
        int low = 1;
        int high = n;
        while (low <= high){
            int mid = (high - low)/2 +  low;
            int coins = (mid * mid + mid)/2;
            if(coins == n){
                return mid;
            }if(coins > n){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return high;//没有找到分会high
    }

    //牛顿迭代法
    public static int arrange003(int n){
        if(n == 0){
            return 0;
        }
        return (int)sqrt(n,n);
    }


    private static double sqrt(double x, int n) {
        double res = (x + (2 * n-x)/x)/2;
        if(res == x){
            return x;
        }else {
            return sqrt(res,n);
        }
    }

}
