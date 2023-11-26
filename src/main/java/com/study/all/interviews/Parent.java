package com.study.all.interviews;

public class Parent extends Test implements First, Second {


//    static void getName() {
//        System.out.println("Second");
//    }
//
//    @Override
//    public static void itsStatic() {
//        System.out.println("In Static Method of Parent");
//    }



    @Override
    protected void itsNonStatic() {
        System.out.println("In Non-Static Method in Parent");
    }

    @Override
    public void getName() {
        Second.super.getName();
    }

    @Override
    public void absMethod() {
        System.out.println("String");
    }
}
