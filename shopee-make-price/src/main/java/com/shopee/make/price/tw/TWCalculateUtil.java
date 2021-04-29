package com.shopee.make.price.tw;

import java.math.BigDecimal;

/**
 * @author: cxz
 * @create: 2021/1/4 18:18
 * @description:
 **/
public class TWCalculateUtil {


    /**
     *  台湾比/人民币 汇率
     */
    private static final BigDecimal tw_rate = new BigDecimal("4.3");

    //普货和特货首重重量(g)
    private static final int initWeight = 500;
    //普货和特货续重步幅
    private static final int weightStep = 500;
    //普货和特货买家价格(台币)
    private static final int commonAndSpecialBuyAmount = 70;
    //普货买家运费(台币)
    private static final int commonSaleFirstAmount =15;
    //特货买家运费(台币)
    private static final int specialSaleFirstAmount = 35;
    //普货续费价格(台币)
    private static final int commonShopAmountStep = 30;
    //特货续费价格(台币)
    private static final int specialShopAmountStep = 40;
    //货代首重(g)
    private static final int shopForwarderFirstWeight = 1000;
    //货代续重步幅（g）
    private static final int shopForwarderWeightStep = 500;
    //货代续重价格步幅（元）
    private static final double shopForwarderAmountStep = 0.5;
    //货代首重价格(元)
    private static final int shopForwarderFirstAmount = 3;
    //佣金费率
    private static final BigDecimal commissionRate = new BigDecimal("0.06");
    //手续费率
    private static final BigDecimal proceduresRate = new BigDecimal("0.02");


    public static String makePriceBase(int buyPrice,int profit,int weight,int shopType,double rebate){
       return makePrice(buyPrice, profit, weight, shopType,true,rebate,false);
    }
    /**
     * @author: cxz
     * @create: 2021/1/4 18:19
     * @param:  [buyPrice, profit, weight, shopType, commissionFlag, rebate, freeShipFlag]
     * @return: java.lang.String
     * @description:
     * buyPrice:成本价（人民币元）
     * profit：利润   （人民币元）
     * weight：商品重量 （单位g）
     * shopType：商品类型 （1：普货 2：特货）
     * commissionFlag： 佣金标识 （true：需收取佣金 false：不需收取佣金）
     * rebate：折扣 （允许可以打得折扣 范围1~10  10代表不打折，9：商品可以打九折）
     * freeShipFlag：免邮标识（true：免邮 false：不免邮）
     */
    public static String makePrice(int buyPrice,int profit,int weight,int shopType,boolean commissionFlag,double rebate,boolean freeShipFlag){
        if(buyPrice<=0){
            return "采购总价不能小于等于零";
        }
        if(profit <=0){
            return "利润不能小于等于零";
        }

        if(weight <=0){
            return "重量（g）不能小于等于零";
        }

        if(shopType <1 || shopType >2){
            return "商品类型输入错误，请输入1或2 【1:普货，2:特货】";
        }
        if(new BigDecimal(rebate).compareTo(new BigDecimal("10"))>0 ||new BigDecimal(rebate).compareTo(new BigDecimal("1"))<0){
            return "商品折扣返回只能大于等于（1折）并且小于等于10折（不打折）";
        }
        //采购价格台币
        BigDecimal buyPriceTW = new BigDecimal(String.valueOf(buyPrice)).multiply(tw_rate);
        //利润台币
        BigDecimal profitTW = new BigDecimal(String.valueOf(profit)).multiply(tw_rate);
        //运费藏价台币
        BigDecimal hideAmountTW;
        if(shopType == 1){
            //普货
            hideAmountTW =new BigDecimal(String.valueOf(commonSaleFirstAmount));
            if(weight >=initWeight){
                //普货超重
                int num = ((weight-initWeight) / weightStep+1);
                hideAmountTW = hideAmountTW.add(new BigDecimal(String.valueOf(commonShopAmountStep*num)));
            }
        }else {
            //特货
            hideAmountTW =new BigDecimal(String.valueOf(specialSaleFirstAmount));
            if(weight>=initWeight){
                //特货超重
                int num = ((weight-initWeight) / weightStep+1);
                hideAmountTW = hideAmountTW.add(new BigDecimal(String.valueOf(specialShopAmountStep*num)));
            }
        }
        if(freeShipFlag){
            hideAmountTW = hideAmountTW.add(new BigDecimal(commonAndSpecialBuyAmount));
        }
        //货代费用台币
        BigDecimal hdAmountTW = new BigDecimal(String.valueOf(shopForwarderFirstAmount)).multiply(tw_rate);
        if(weight >=shopForwarderFirstWeight){
            int num = ((weight-shopForwarderFirstWeight) / shopForwarderWeightStep +1);
            BigDecimal otherHdAmountTw = new BigDecimal(String.valueOf(num)).multiply(new BigDecimal(String.valueOf(shopForwarderAmountStep))).multiply(tw_rate);
            hdAmountTW = hdAmountTW.add(otherHdAmountTw);
        }

        BigDecimal shopPriceBefore = buyPriceTW.add(profitTW).add(hideAmountTW).add(hdAmountTW);
        BigDecimal shopPriceAll  = (shopPriceBefore.multiply(new BigDecimal("1").add(commissionFlag?commissionRate:new BigDecimal("0")).add(proceduresRate))).add(proceduresRate.multiply(freeShipFlag?new BigDecimal("0"):new BigDecimal(String.valueOf(commonAndSpecialBuyAmount))));

        String str = "%s[商品总价] = (%s[采购台币]+%s[利润台币]+%s[运费藏价台币]+%s[货代费用台币])*(1+%s[佣金比率]+%s[手续费比率]) + （%s[买家运费]*%s[手续费比率]";
        String result = String.format(str,shopPriceAll.toString(),buyPriceTW.toString(),profitTW.toString(),hideAmountTW.toString(),hdAmountTW.toString(),commissionFlag?commissionRate.toString():"0",
                proceduresRate.toString(),String.valueOf(freeShipFlag?0:commonAndSpecialBuyAmount),proceduresRate.toString());
        System.out.println(result);
        System.out.println();
        BigDecimal rebateTemp = new BigDecimal(String.valueOf(rebate)).divide(new BigDecimal(10),2,BigDecimal.ROUND_HALF_UP);
        return "原价：" + shopPriceAll.divide(rebateTemp,2,BigDecimal.ROUND_HALF_UP);
    }
}
