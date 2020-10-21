package com.gof.code.mediator;

/**
 * @author: cxz
 * @create: 2020/8/12 15:13
 * @description:
 **/
public class MediatorHandler implements Mediator {

    private HouseOwner oneHouseOwner;
    private HouseOwner twoHouseOwner;
    private HouseOwner threeHouseOwner;

    public MediatorHandler(HouseOwner oneHouseOwner, HouseOwner twoHouseOwner, HouseOwner threeHouseOwner) {
        this.oneHouseOwner = oneHouseOwner;
        this.twoHouseOwner = twoHouseOwner;
        this.threeHouseOwner = threeHouseOwner;
    }

    @Override
    public void execute(int house) {
        switch (house){
            case 1:
                System.out.println("可以出租一居室");
                oneHouseOwner.handler();
                break;
            case 2:
                System.out.println("可以以出租两居室");
                twoHouseOwner.handler();
                break;
            case 3:
                System.out.println("可以出租三居室");
                threeHouseOwner.handler();
                break;
            default:
                System.out.println("没有改房源");
        }
    }
}
