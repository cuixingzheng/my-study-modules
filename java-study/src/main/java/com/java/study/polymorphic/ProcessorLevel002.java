package com.java.study.polymorphic;

public abstract class ProcessorLevel002 implements Processor {

    @Override
    public void handler() {
        System.out.println("abstract ProcessorLevel002 is handle ....");
    }


    public void handler002() {
        System.out.println("abstract ProcessorLevel002 is handler002 ....");
    }
}
