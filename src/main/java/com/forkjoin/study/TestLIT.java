package com.forkjoin.study;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TestLIT {

    public static void main(String[] args) {
        printPrimeNumbers();
    }

    public static void printPrimeNumbers() {
        List<Integer> integerList = new ArrayList<>();
        IntStream.rangeClosed(2,100).forEach(number -> { if(IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0)) {
            integerList.add(number);
        }
        });

        integerList.forEach(System.out::println);

    }
}
