package com.study.all.study;

public class TestForStaticClass extends Car {

    public static void main(String[] args) {
    PrintIt printIt = new PrintIt();

    }

    @Override
    public void spin() {
        System.out.println("Spin the wheel");
    }

    static class PrintIt {

        private int count;
        public int testthecode() {

            return 1;
        }
    }

}

