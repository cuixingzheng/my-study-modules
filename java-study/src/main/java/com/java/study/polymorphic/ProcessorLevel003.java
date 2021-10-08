package com.java.study.polymorphic;

public class ProcessorLevel003 extends ProcessorLevel002 {

    @Override
    public void handler() {
        System.out.println("abstract ProcessorLevel003 is handle ....");
    }


    public void handler003() {
        System.out.println("abstract ProcessorLevel003 is handler003 ....");
    }
}
