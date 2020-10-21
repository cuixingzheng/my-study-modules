package com.gof.code.visit;

public interface Part {
    void describe();
    void accept(Visitor visitor);
}
