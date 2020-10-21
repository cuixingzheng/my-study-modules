package com.gof.code.adapter;

/**
 * @author: cxz
 * @create: 2020/8/5 14:54
 * @description:
 **/
public class AdapterTest {

    public static void main(String[] args) {

        //1.使用继承方式适配
        ThreePower threePower = new TwoToThreePowerAdapter001();
        Computer computer = new Computer(threePower);
        computer.work();
        System.out.println("===============================");
        //使用类依赖方式适配
        ThreePower threePower1 = new TwoToThreePowerAdapter002(new TwoPowerPo());
        Computer computer1 = new Computer(threePower1);
        computer1.work();

    }
}
