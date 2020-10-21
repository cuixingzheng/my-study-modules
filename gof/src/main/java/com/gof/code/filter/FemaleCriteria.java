package com.gof.code.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: cxz
 * @create: 2020/8/7 11:41
 * @description:
 **/
public class FemaleCriteria implements Criteria<Person> {
    @Override
    public List<Person> filter(List<Person> targets) {
        return targets.stream().filter(o ->"female".equals(o.getGender().toLowerCase())).collect(Collectors.toList());
    }
}
