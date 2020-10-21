package com.gof.code.filter;

import java.util.List;

/**
 * @author: cxz
 * @create: 2020/8/7 14:56
 * @description:
 **/
public class OrCriteria implements Criteria<Person>{
    private Criteria<Person> firstCriteria;
    private Criteria<Person> secondCriteria;
    public OrCriteria(Criteria<Person> firstCriteria, Criteria<Person> secondCriteria) {
        this.firstCriteria = firstCriteria;
        this.secondCriteria = secondCriteria;
    }
    @Override
    public List<Person> filter(List<Person> targets) {
        List<Person> list = firstCriteria.filter(targets);
        List<Person> list1 = secondCriteria.filter(targets);
        list1.forEach(o -> {
            if(!list.contains(o)){
                list.add(o);
            }
        });
        return list;
    }
}
