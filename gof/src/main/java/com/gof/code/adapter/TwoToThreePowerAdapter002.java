package com.gof.code.adapter;

/**
 * @author: cxz
 * @create: 2020/8/5 14:52
 * @description:
 **/
public class TwoToThreePowerAdapter002  implements ThreePower {

    private TwoPowerPo twoPowerPo;

    public TwoToThreePowerAdapter002(TwoPowerPo twoPowerPo) {
        this.twoPowerPo = twoPowerPo;
    }

    @Override
    public void supplyThreePower() {
        twoPowerPo.supplyTwoPower();
    }
}
