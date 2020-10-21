package com.gof.code.adapter;

/**
 * @author: cxz
 * @create: 2020/8/5 14:52
 * @description:
 **/
public class TwoToThreePowerAdapter001 extends TwoPowerPo implements ThreePower {

    @Override
    public void supplyThreePower() {
        super.supplyTwoPower();
    }
}
