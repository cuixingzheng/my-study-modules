package com.gof.code.mediator;

/**
 * @author: cxz
 * @create: 2020/8/12 15:17
 * @description:
 **/
public class MediatorTest {
    public static void main(String[] args) {
        HouseOwner oneHouseOwner = new OneHouseOwner();
        HouseOwner twoHouseOwner = new TwoHouseOwner();
        HouseOwner threeHouseOwner = new ThreeHouseOwner();
        Mediator mediator = new MediatorHandler(oneHouseOwner,twoHouseOwner,threeHouseOwner);

        //需要一居室
        mediator.execute(1);
        System.out.println();
        //需要三居室
        mediator.execute(3);
        System.out.println();
        //需要4居室
        mediator.execute(4);
    }
}
