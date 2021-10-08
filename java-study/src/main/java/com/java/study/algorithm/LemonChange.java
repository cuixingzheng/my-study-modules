package com.java.study.algorithm;

/**
 * @author: cxz
 * @create: 2021/5/11 18:56
 * @description: 柠檬水找零
 **/
public class LemonChange {
    /**
     * @author: cxz
     * @description: 柠檬水找零:销售柠檬水，每杯柠檬水售价为5美元，顾客排队购买柠檬水，一次购买一杯
     * 顾客首重的币值只有：5、10、20美元，现在要求随意一个输入一个数组，如果能够正确的找零返回true，否则返回false
     */

    public static void main(String[] args) {
        int[] array = {5,10,5,5,10};
        System.out.println(change(array));
    }

    //贪心算法 时间复杂度o(n),空间复杂度o(1)（能够找零的只有5和10，其中给20找零时首先选择10和5，否则使用三个5）
    public static boolean change(int[] array){
        int five = 0;
        int ten = 0;
        for (int i = 0; i < array.length ; i++) {
            if(array[i] == 5){
                five ++;
            }else if(array[i] == 10){
                if(five<=0){
                    return false;
                }
                five--;
                ten++;
            }else {
                if(five > 0 && ten > 0){//首先使用该方案
                    five--;
                    ten--;
                }else if(five>=3){
                    five -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

}
