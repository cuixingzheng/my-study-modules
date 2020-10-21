package com.gof.code.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: cxz
 * @create: 2020/8/5 16:25
 * @description:
 **/
public class Meal {

    public  List<Item> items = new ArrayList<>();

    public  float allPrice(){
        float price = 0f;
        for (Item item : items){
            price += item.getPrice();
        }
        return price;
    }

    public  void showItem(){
        for (Item item : items){
            System.out.println("name = " + item.getName());
            System.out.println("price = " + item.getPrice());
            System.out.println("packing = " + item.getPacking().pack());
        }
    }
}
