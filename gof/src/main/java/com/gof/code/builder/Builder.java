package com.gof.code.builder;

/**
 * @author: cxz
 * @create: 2020/8/5 16:31
 * @description:
 **/
public class Builder {

    public static Meal vegMeal(){
        Meal meal = new Meal();
        meal.items.add(new VegBurger());
        meal.items.add(new Coke());
        return meal;
    }

    public static Meal nonVegMeal(){
        Meal meal = new Meal();
        meal.items.add(new ChickenBurger());
        meal.items.add(new Pepsi());
        return meal;
    }
}
