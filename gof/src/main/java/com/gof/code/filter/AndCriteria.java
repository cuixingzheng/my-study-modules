package com.gof.code.filter;

import java.util.List;

/**
 * @author: cxz
 * @create: 2020/8/7 13:43
 * @description:
 **/
public class AndCriteria implements Criteria<Person>{
    private Criteria<Person> firstCriteria;
    private Criteria<Person> secondCriteria;
    public AndCriteria(Criteria<Person> firstCriteria, Criteria<Person> secondCriteria) {
        this.firstCriteria = firstCriteria;
        this.secondCriteria = secondCriteria;
    }
    @Override
    public List<Person> filter(List<Person> targets) {
        return secondCriteria.filter(firstCriteria.filter(targets));
    }
}
