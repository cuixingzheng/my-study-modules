package com.gof.code.interpreter;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author: cxz
 * @create: 2020/8/13 17:38
 * @description:
 **/
public class Context {
    private String[] citys = {"广州","深圳","韶关","中山"};
    private String[] persons = {"老人","孩子","残疾","孕妇"};
    private Expression citysExp;
    private Expression personsExp;
    private Expression andPxp;

    public Context() {
        this.citysExp = new TerminalExpression(new HashSet<>(Arrays.asList(citys)));
        this.personsExp = new TerminalExpression(new HashSet<>(Arrays.asList(persons)));
        andPxp = new AndExpression(citysExp,personsExp);
    }
    public void handleInfo(String info){
        boolean interpreter = andPxp.interpreter(info);
        if(interpreter){
            System.out.println(info + "可以免费坐车");
        }else {
            System.out.println(info + "不可以免费坐车，扣款2元");
        }
    }
}
