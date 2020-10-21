package com.gof.code.filter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: cxz
 * @create: 2020/8/7 11:41
 * @description:
 **/
public class MaleCriteria implements Criteria<Person> {
    @Override
    public List<Person> filter(List<Person> targets) {
        return targets.stream().filter(o ->"male".equals(o.getGender().toLowerCase())).collect(Collectors.toList());
    }
}
