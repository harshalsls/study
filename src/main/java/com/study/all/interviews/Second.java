package com.study.all.interviews;

public interface Second {

    default void getName() {
        System.out.println("Second");
    }

    void absMethod();
}
