package com.gof.code.factory;

/**
 * @author: cxz
 * @create: 2020/8/4 18:54
 * @description:
 **/
public class MobileFactory {

    public static Mobile createMobile(String name){
        if("苹果".contains(name.trim())){
            return new Iphone();
        }else if("三星".contains(name.trim())){
            return new Samsung();
        }else {
            throw new NullPointerException("暂无法生产该手机");
        }
    }
}
