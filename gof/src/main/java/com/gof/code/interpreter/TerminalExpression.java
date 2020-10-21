package com.gof.code.interpreter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: cxz
 * @create: 2020/8/13 17:32
 * @description:
 **/
public class TerminalExpression implements Expression  {
    private Set<String> datas = new HashSet<>();
    public TerminalExpression(Set<String> datas) {
        this.datas = datas;
    }
    @Override
    public boolean interpreter(String info) {
        return datas.contains(info);
    }
}
