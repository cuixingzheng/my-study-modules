package com.gof.code.state;

/**
 * @author: cxz
 * @create: 2020/8/13 11:12
 * @description:
 **/
public class StateTest {
    public static void main(String[] args) {
        Hero hero = new Hero(new CommonState());
        System.out.println(hero.getState());
        new SpeedUpState().handle(hero);
        System.out.println(hero.getState());
        new SpeedDownState().handle(hero);
        System.out.println(hero.getState());
        new SwimState().handle(hero);
        System.out.println(hero.getState());
    }
}
