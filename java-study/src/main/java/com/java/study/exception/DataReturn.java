package com.java.study.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: cxz
 * @create: 2021/7/2 13:40
 * @description:
 **/
public class DataReturn {

    public static void main(String[] args) {
        //System.out.println(tryReturn());
        //System.out.println(txt());
        //System.out.println(testReturn1());
        //System.out.println(testReturn2());
        //System.out.println(testReturn3());
        System.out.println(testReturn4());
    }

    private static int testReturn4() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            int i1 = 1 / 0;
            //return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
            return i;
        } finally {
            i++;
            System.out.println("finally:" + i);
            return i;
        }
    }


    private static int tryReturn() {
        try {
            return 1;
        }catch (Exception e){
            return 2;
        }finally {
            return 3;
        }
    }




    private static int testReturn1() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
        } finally {
            i++;
            System.out.println("finally:" + i);
        }
        return i;
    }

    private static List<Integer> testReturn2() {
        List<Integer> list = new ArrayList<>();
        try {
            list.add(1);
            System.out.println("try:" + list);
            return list;
        } catch (Exception e) {
            list.add(2);
            System.out.println("catch:" + list);
        } finally {
            list.add(3);
            System.out.println("finally:" + list);
        }
        return list;
    }
    private static List<Integer> testReturn3() {
        List<Integer> list = new ArrayList<>();
        try {
            list.add(1);
            System.out.println("try:" + list);
            return list;
        } catch (Exception e) {
            list.add(2);
            System.out.println("catch:" + list);
        } finally {
            list = Collections.singletonList(10);
            System.out.println("finally:" + list);
        }
        return list;
    }



    static int txt(){
        try {
            @SuppressWarnings("unused")
            int a=5/0;

        } catch (Exception e) {
            System.out.println("catch");
            return 2;
        }finally{
            System.out.println("finally");
        }
        return 3;
    }
}
