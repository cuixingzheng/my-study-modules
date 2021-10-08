package com.gof.code.spi;

/**
 * @author: cxz
 * @create: 2021/5/31 18:42
 * @description:
 **/
public class SalaryCalerServiceImpl100 implements SalaryCalerService {
    @Override
    public double cal(Double salary) {
        return salary * 1.2;
    }
}
