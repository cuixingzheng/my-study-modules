package com.gof.code.nullobject;

import java.util.Arrays;

/**
 * @author: cxz
 * @create: 2020/8/13 16:28
 * @description:
 **/
public class FactoryBook {
    private String[] names = {"西游记","红楼梦","三国演义"};
    public  Book getBook(String name){
        return  Arrays.asList(names).contains(name)?new RealBook(name):new NullBook(name);
    }
}
