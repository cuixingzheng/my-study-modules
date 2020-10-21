package com.gof.code.iterator;

/**
 * @author: cxz
 * @create: 2020/8/12 14:30
 * @description:
 **/
public class IteratorTest {

    public static void main(String[] args) {
        NumContainer numContainer = new NumContainer();
        for (Iterator iterator = numContainer.getIterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }
    }
}
