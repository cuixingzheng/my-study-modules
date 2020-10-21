package com.gof.code.filter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: cxz
 * @create: 2020/8/7 13:41
 * @description:
 **/
public class SingleCriteria implements Criteria<Person>{
    @Override
    public List<Person> filter(List<Person> targets) {
        return targets.stream().filter(o -> "single".equals(o.getMaritalStatus().toLowerCase())).collect(Collectors.toList());
    }
}
