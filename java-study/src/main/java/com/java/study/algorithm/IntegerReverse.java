package com.java.study.algorithm;

/**
 * @author: cxz
 * @create: 2021/5/18 16:46
 * @description: 整数反转
 **/
public class IntegerReverse {

    public static void main(String[] args) {
        Integer num = -1022555459;
        //System.out.println(reverse(num));
        //System.out.println(reverse1(num));
        //System.out.println(reverse2(num));
        //System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println((Integer.MIN_VALUE+0) * -1);
        System.out.println((Integer.MAX_VALUE + 1));

        System.out.println(reverse2(num));

    }

    //允许存储64位
    public static int reverse(Integer num){
        if(num == null || num == 0){
            return 0;
        }
        String value = String.valueOf(num);
        boolean flag = false;
        if(value.charAt(0) == '-'){//判断负数
            value = value.substring(1);
            flag = true;
        }
        boolean isZero = false;
        StringBuffer sb = new StringBuffer();
        for (int i = value.length()-1; i >=0; i--) {
            if(value.charAt(i) == '0' && !isZero){

            }else {
                sb.append(value.charAt(i));
                isZero = true;
            }
        }

        Long result = Long.valueOf(sb.toString());
        result = flag?-result:result;
        if(result>=0){
            if(result > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }else {
            if(result< Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return result.intValue();
    }

    //使用字符串截取（不允许存储64位）
    public static int reverse1(Integer num){
        if(num == null || num == 0){
            return 0;
        }
        String value = String.valueOf(num);
        boolean flag = false;
        if(num <0){//判断负数
            value = value.substring(1);
            flag = true;
        }
        boolean isZero = false;
        StringBuffer sb = new StringBuffer();
        for (int i = value.length()-1; i >=0; i--) {
            if(value.charAt(i) == '0' && !isZero){

            }else {
                sb.append(value.charAt(i));
                isZero = true;
            }
        }
        String sbValue = sb.toString();
        boolean flag001 = false;
        if(!flag && String.valueOf(Integer.MAX_VALUE).length() == sbValue.length()){//为正数 并且位数与最大数长度相同
            String maxStr = String.valueOf(Integer.MAX_VALUE);
            for (int i = 0; i < maxStr.length(); i++) {
                int sbModel = Integer.parseInt(String.valueOf(sb.charAt(i)));
                int sbMode2 = Integer.parseInt(String.valueOf(maxStr.charAt(i)));
                if(!flag001){//没有出现低位
                    if(sbModel > sbMode2){//大于时直接直接返回
                        return 0;
                    }else if(sbModel == sbMode2){//等于时继续执行
                        continue;
                    }else {
                        flag001 = true;
                    }
                }
            }
        }else if(flag && (String.valueOf(Integer.MIN_VALUE).length()-1) == sbValue.length()){//为负数 并且长度与最小数长度相同
            String maxStr = String.valueOf(Integer.MIN_VALUE);
            for (int i = 0; i < sb.length(); i++) {
                int sbModel = Integer.parseInt(String.valueOf(sb.charAt(i)));
                int sbMode2 = Integer.parseInt(String.valueOf(maxStr.charAt(i+1)));
                if(!flag001){//没有出现低位
                    if(sbModel > sbMode2){//大于时直接直接返回
                        return 0;
                    }else if(sbModel == sbMode2){//等于时继续执行
                        continue;
                    }else {
                        flag001 = true;
                    }
                }
            }
        }
        String res;
        if(flag){
            res = "-" + sb.toString();
        }else {
            res = sb.toString();
        }
        return Integer.parseInt(res);
    }

    public static int reverse2(int num){
        int res = 0;
        while (num != 0){
            int temp = res;
            temp = temp*10 + num%10;
            num = num/10;
            if(temp/10 != res){//检查是否超过最大32位
                return 0;
            }
            res = temp;
        }
        return  res;
    }



}
