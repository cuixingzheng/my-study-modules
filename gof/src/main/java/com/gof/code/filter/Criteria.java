package com.gof.code.filter;

import java.util.List;

public interface Criteria <T> {
    List<T> filter(List<T> targets);
}
