package com.gof.code.filter;

import java.util.Objects;

/**
 * @author: cxz
 * @create: 2020/8/7 11:33
 * @description: 过滤器模式
 **/
public class Person {
    private String name;
    private String gender;
    private String maritalStatus;
    public Person(String name, String gender, String maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(gender, person.gender) &&
                Objects.equals(maritalStatus, person.maritalStatus);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, gender, maritalStatus);
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                '}';
    }
}
