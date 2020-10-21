package com.java.study.algorithm;

import com.java.study.io.Person;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: cxz
 * @create: 2020/8/31 17:34
 * @description:
 **/
public class Sort {
    public static void main(String[] args) {
        //mpSort();
        //xzSort();
        //listSort();
        //quickSort();
        final int N = 100000;
        int a[] = new int[N];   //冒泡排序
        int b[] = new int[N];   //选择排序
        int c[] = new int[N];   //快速排序
        for(int i = 0;i<a.length;i++) {
            a[i] = (int)((Math.random())*50001);
            b[i] = a[i];
            c[i] = a[i];
        }
        long start = System.currentTimeMillis();
        mpSort(a);
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序时间：" + (end-start));

         start = System.currentTimeMillis();
        xzSort(b);
         end = System.currentTimeMillis();
        System.out.println("选择排序时间：" + (end-start));

        start = System.currentTimeMillis();
        quickSort(c);
         end = System.currentTimeMillis();
        System.out.println("快速排序时间：" + (end-start));
    }
    private static void mpSort(int[] array){
        //使用冒泡，将数据从小到大排序
        //冒泡排序逻辑，将数据两两比较，如果前者比后者大则交换位置
        //int[] array = {35,3,5,75,55,9,23,46,233,1,90};
        for(int i=0;i<array.length-1;i++){//需要冒泡的次数length-1次
            for(int j=0;j<(array.length-i-1);j++){//比较次数为length-1-i次
                if(array[j]>array[j+1]){//两两比较，将大的数据放在之后
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
//        for (int value : array) {
//            System.out.println(value);
//        }
    }

    private static void xzSort(int[] array){
        //使用选择排序 将数据从大到小排序
        //选择排序逻辑，假如第一为最大值，记录索引，将最大值与其他依次比较，如果有更大值则将更大值索引进行交换，直到比较完毕
        //int[] array = {35,3,5,75,55,9,23,46,233,1,90};
        for(int i=0;i<array.length-1;i++){//需要选择array.length-1次即可
            int max = i;
            for(int j=i+1;j<array.length;j++){//每次需要比较次数
                if(array[max]<array[j]){//如果后面值大，换索引
                    int temp = max;
                    max=j;
                    j = temp;
                }
            }
            if(max != i){//如果索引不同，需要将两个索引值交换
                int temp = array[i];
                array[i] = array[max];
                array[max] = temp;
            }
        }
//        for (int value : array) {
//            System.out.println(value);
//        }
    }

    private static void listSort(){
        List<Integer> list = Arrays.asList(35, 3, 5, 75, 55, 9, 23, 46, 233, 1, 90);
        list.sort(((o1, o2) -> o2-o1));
        System.out.println(Arrays.toString(list.toArray()));
        List<Person> peoples =  new ArrayList<>();
        peoples.add(new Person(45,"张三",34));
        peoples.add(new Person(42,"李四",35));
        peoples.add(new Person(46,"王五",56));
        peoples.add(new Person(41,"赵六",54));
        peoples.add(new Person(44,"马七",32));
        peoples.sort(Comparator.comparing(Person::getId).thenComparing(Person::getAge));
        System.out.println(Arrays.toString(peoples.toArray()));
    }

    /**
     * @author: cxz
     * 算法思想：1、将数组第一个作为基准，i,j作为左右指针 2、将右指针找到比基准晓得数、将左指针从第一位开始找到比基准大的数，然后将其位置交换
     * 3、重复上述的逻辑直到i,j指针值相同，最后将基准与i位置交换，得到两个以基准为中间点数组 4、将得到两个组数使用递归继续排序，直到分组后数组止到一个元素
     **/
    private static void quickSort(int[] array){
        //int[] array = {35,3,5,75,55,9,23,46,233,1,90};
        int low = 0;
        int high = array.length-1;
        //输出无序数组
        //System.out.println(Arrays.toString(array));
        //快速排序
        quickSort(array,low,high);
        //输出有序数组
       // System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array,int low,int high){
        if(low>=high){
            return ;
        }
        int flag = array[low];//将第一个设置为基准
        int i = low;//左侧指针
        int j = high;//右侧指针
        while (i < j) {//当i==j时一次分区结束，会得到一个基准右边都比基准要大，基准左边都比基准要小
            //1.从右向左移动j，找到第一个小于基准值的值array[j],比基准值小的需要交换，如果没有找到则指针左右指针会碰头。
            while (array[j] >= flag && i < j) {
                j--;
            }
            //2.从左向右移动i，找到第一个大于基准值的值array[i],比基准值大的需要交换，如果没有找到则指针左右指针会碰头。
            while (array[i] <= flag && i < j) {
                i++;
            }
            if (i<j) {//左右指针没有碰头时，将两个数据交换
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        //跳出循环时说明左右指针碰头,则将第一个（也是基准）与碰头位置交换，一次分区结束
        array[low] = array[i];
        array[i] = flag;
        //递归调用左半数组
        quickSort(array, low, i-1);
        //递归调用右半数组
        quickSort(array, i+1, high);
    }









}
