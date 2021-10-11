package com.java.study.generic;

/**
 * @author : cxz
 * @version : 1.0
 * @date : 2021/10/8 15:43
 * @description : 泛型
 **/
public class GenericTest<T> {

    private Integer code;

    private T response(T result){
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
