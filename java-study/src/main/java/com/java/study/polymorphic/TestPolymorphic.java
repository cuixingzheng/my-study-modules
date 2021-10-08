package com.java.study.polymorphic;

/**
 * @author: cxz
 * @create: 2021/6/21 14:40
 * @description:
 **/
public class TestPolymorphic {

    public static void main(String[] args) {
        Processor processor = new ProcessorLevel003();
        processor.handler();
        if(processor instanceof ProcessorLevel002){
            ((ProcessorLevel002)processor).handler002();
        }
    }
}
