package com.gof.code.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: cxz
 * @create: 2020/8/7 16:06
 * @description:
 **/
public class FilterTest {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Robert","Male", "Single"));
        persons.add(new Person("John","Male", "Married"));
        persons.add(new Person("Laura","Female", "Married"));
        persons.add(new Person("Diana","Female", "Single"));
        persons.add(new Person("Mike","Male", "Single"));
        persons.add(new Person("Bobby","Male", "Single"));

        Criteria<Person> male = new MaleCriteria();
        Criteria<Person> female = new FemaleCriteria();
        Criteria<Person> single = new SingleCriteria();
        Criteria<Person> maleSingle = new AndCriteria(male,single);
        Criteria<Person> maleOrSingle = new OrCriteria(male,single);

        System.out.println("males:");
        printPersons(male.filter(persons));
        System.out.println();

        System.out.println("females:");
        printPersons(female.filter(persons));
        System.out.println();

        System.out.println("singles:");
        printPersons(single.filter(persons));
        System.out.println();

        System.out.println("males and singles:");
        printPersons(maleSingle.filter(persons));
        System.out.println();

        System.out.println("males or singles:");
        printPersons(maleOrSingle.filter(persons));
        System.out.println();
    }

    public static void printPersons(List<Person> persons){
        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName()
                    +", Gender : " + person.getGender()
                    +", Marital Status : " + person.getMaritalStatus()
                    +" ]");
        }
    }
}
