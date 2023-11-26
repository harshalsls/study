package com.study.all.interviews;

public interface First {

    default void getName() {
        System.out.println("Second");
    }

    void absMethod();
}
