package com.gof.code.iterator;

/**
 * @author: cxz
 * @create: 2020/8/12 14:24
 * @description:
 **/
public class NumContainer implements Container {

    Integer[] nums = {10,20,5,3,60,90,100};

    @Override
    public Iterator getIterator() {
        return new NumIterator();
    }

    public class NumIterator implements Iterator{
        int index = 0;
        @Override
        public boolean hasNext() {
            return index < nums.length;
        }

        @Override
        public Object next() {
            if(hasNext()){
                return  nums[index++];
            }
            throw new IndexOutOfBoundsException("对象越界");
        }
    }

}
