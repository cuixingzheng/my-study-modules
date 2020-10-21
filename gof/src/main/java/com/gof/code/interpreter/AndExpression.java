package com.gof.code.interpreter;

/**
 * @author: cxz
 * @create: 2020/8/13 17:34
 * @description:
 **/
public class AndExpression implements Expression{
    private Expression citys;
    private Expression persons;
    public AndExpression(Expression citys, Expression persons) {
        this.citys = citys;
        this.persons = persons;
    }
    @Override
    public boolean interpreter(String info) {
        String[] split = info.split("的");
        return split.length == 2 && (citys.interpreter(split[0]) && persons.interpreter(split[1]));
    }
}
