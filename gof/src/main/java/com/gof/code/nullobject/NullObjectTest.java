package com.gof.code.nullobject;

/**
 * @author: cxz
 * @create: 2020/8/13 16:32
 * @description:
 **/
public class NullObjectTest {

    public static void main(String[] args) {
        FactoryBook factoryBook = new FactoryBook();
        Book book = factoryBook.getBook("三国演义");
        book.show();
        book = factoryBook.getBook("西游记");
        book.show();
        book = factoryBook.getBook("红楼梦");
        book.show();
        book = factoryBook.getBook("水浒传");
        book.show();
    }
}
