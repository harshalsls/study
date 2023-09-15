package com.epam.task;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CoforgeTask {

    public static void main(String[] args) {
        List<Character> list = Arrays.asList('H', 'A', 'R', 'S', 'H', 'A', 'L');

        printNonRepeating(list);
    }

    public static void printNonRepeating(List<Character> list) {

        Map<Character, Long> collect = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        for (Character c :collect.keySet()) {
            if(collect.get(c)  < 2) {
                System.out.print(" " + c);
            }

        }


    }

}
