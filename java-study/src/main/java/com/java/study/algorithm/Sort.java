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
//        final int N = 100;
//        int a[] = new int[N];   //冒泡排序
//        int b[] = new int[N];   //选择排序
//        int c[] = new int[N];   //快速排序
//        for(int i = 0;i<a.length;i++) {
//            a[i] = (int)((Math.random())*50001);
//            b[i] = a[i];
//            c[i] = a[i];
//        }
//        long start = System.currentTimeMillis();
//        mpSort(a);
//        long end = System.currentTimeMillis();
//        System.out.println("冒泡排序时间：" + (end-start));
//
//         start = System.currentTimeMillis();
//        xzSort(b);
//         end = System.currentTimeMillis();
//        System.out.println("选择排序时间：" + (end-start));
//
//        start = System.currentTimeMillis();
//        quickSort(c);
//         end = System.currentTimeMillis();
//        System.out.println("快速排序时间：" + (end-start));

//        int[] array = {1,3,5,2,4,6,8,10};
//        mergeSort(array,0,array.length-1);
//        System.out.println(Arrays.toString(array));
        int[] array = {4,10,3,5,1,5,6,2,5,7344,5,67,3,233,21,1};
        //heapSort(array);
//        insertSort(array);
//        System.out.println(Arrays.toString(array));
        baseSort(array);
        System.out.println(Arrays.toString(array));

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




    //基数排序  时间复杂度为o(d(n+k)) 其中d代表位数，n数字个数，k取值范围
    private static void baseSort(int[] array){
        //首先确定排序的趟数;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int time = 0;
        //判断位数;
        while (max > 0) {
            max /= 10;
            time++;
        }
        //建立10个队列;
        List<ArrayList> queue = new ArrayList<ArrayList>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queue1 = new ArrayList<Integer>();
            queue.add(queue1);
        }
        //进行time次分配和收集;
        for (int i = 0; i < time; i++) {
            //分配数组元素;
            for (int j = 0; j < array.length; j++) {
                //得到数字的第time+1位数;
                int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(array[j]);
                queue.set(x, queue2);
            }
            int count = 0;//元素计数器;
            //收集队列元素;
            for (int k = 0; k < 10; k++) {
                while (queue.get(k).size() > 0) {
                    ArrayList<Integer> queue3 = queue.get(k);
                    array[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //归并排序 时间复杂度o(nlogn) 空间复杂度o(n) 稳定
    public static void mergeSort(int[] arr,int low,int high) {
        int middle = (high + low) / 2;
        if (low < high) {
            mergeSort(arr, low, middle);//递归排序左侧
            mergeSort(arr, middle + 1, high);//递归排序右侧
            merge(arr, low, middle, high);//合并左右两个有序数组
        }
    }

    public static void merge(int[] arr,int low,int middle, int high) {
        int[] temp = new int[high - low + 1];//创建两个有序数组总和长度数组
        int i = low;//左侧数组开始位置
        int j = middle + 1;//右侧数组开始位置
        int index = 0;//临时数组起始位置
        while (i <= middle && j <= high) {//左侧开始位置或右侧开始位置达到该数组尾端跳出循环
            if (arr[i] <= arr[j]) {//两个数组中较小数据放在临时数组中
                temp[index] = arr[i];
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        while (j <= high) {//右侧数组没有达到该数组尾端时，将剩余数据移到临时数组尾端
            temp[index] = arr[j];
            j++;
            index++;
        }
        while (i <= middle) {//左侧数组没有达到该数组尾端时，将剩余数据移到临时数组尾端
            temp[index] = arr[i];
            i++;
            index++;
        }
        for (int k = 0; k < temp.length; k++) {//将临时数组移到原始数组中
            arr[k + low] = temp[k];
        }
    }


    //堆排序 时间复杂度o(nlogn)  空间复杂度o(1)
    //堆特性 1：完全二叉树 2:分为大顶堆（父节点比子节点大）、小顶堆（父节点比子节点小）
    //将序列构建成大顶堆。
    //将根节点与最后一个节点交换，然后断开最后一个节点。
    //重复第一、二步，直到所有节点断开。
    public static void heapSort(int[] tree){
        buildHeap(tree);//将树构建一个堆
        for (int i = tree.length-1; i >= 0; i--) {//将堆顶数据放在数组最后
            swap(tree,i,0);
            heapify(tree,i,0);//将顶部数据继续进行堆处理，同时中断最后一个数据（i变小即可）
        }
        System.out.println(Arrays.toString(tree));
    }

    //构建一个堆
    public static void buildHeap(int[] tree){
        int last_node = tree.length - 1;
        int parent = (last_node -1)/2;//从最后一个节点的父节点开始依次处理节堆结构
        for (int i = parent; i >= 0;i--) {
            heapify(tree,tree.length,i);
        }
    }

    //对某一个节点变成堆节点
    public static void heapify(int[] tree,int length,int i){
        if(i >= length -1){
            return;
        }
        int c1 = 2*i + 1;//左侧子节点位置（堆特性）
        int c2 = 2*i + 2;//左侧子节点位置（堆特性）
        int max =  i;//假如i为最大值的位置
        if(c1 < length && tree[c1] > tree[max]){
            max = c1;
        }
        if(c2 < length && tree[c2] > tree[max]){
            max = c2;
        }
        if(max != i){//出现更大值 需交换
            swap(tree,max,i);
            //递归 将影响的一边继续heapify
            heapify(tree,length,max);
        }
    }
    //数据交换
    public static void swap(int[] tree,int max,int i){
        int temp = tree[max];
        tree[max] = tree[i];
        tree[i] = temp;
    }

    //插入排序 时间复杂度o(n平方) 空间复杂度o(1)
    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int insertNum = array[i];//从第二个开始插入
            int j = i -1;//从排序好的末端位置开始比较
            while (j>=0 && array[j]>insertNum){
                array[j+1] = array[j];//将当前数据向后移动
                j--;
            }
            //将数据插入
            array[j+1] = insertNum;
        }
    }

    //希尔排序（shell排序） 平均时间复杂度o(n1.3) 空间复杂度o(1) 不收敛
    public static void shellSort(int[] array){
        int d = array.length;
        while (d != 0){
            d = d/2;//进行分组，d为分的组数
            for (int g = 0; g < d; g++) {//对每个组进行插入排序
                for (int i = g + d; i < array.length; i+=d) {//从第二个元素开始插入
                    int insertNum = array[i];
                    int j = i-d;//排序后的最后一个元素
                    while (j>=0&&array[j] > insertNum){//
                        array[j + d] = array[j];//将前面的值向后移动
                        j-=d;
                    }
                    array[j+d] = insertNum;//将数据插入
                }
            }
        }
    }




}
