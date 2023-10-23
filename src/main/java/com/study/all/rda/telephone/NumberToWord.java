package com.study.all.rda.telephone;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumberToWord {

    static Character[][] numberToCharMap;

    private static void generateNumberToCharMap() {
        numberToCharMap = new Character[10][5];
        numberToCharMap[0] = new Character[]{'\0'};
        numberToCharMap[1] = new Character[]{'\0'};
        numberToCharMap[2]
                = new Character[]{'a', 'b', 'c'};
        numberToCharMap[3]
                = new Character[]{'d', 'e', 'f'};
        numberToCharMap[4]
                = new Character[]{'g', 'h', 'i'};
        numberToCharMap[5]
                = new Character[]{'j', 'k', 'l'};
        numberToCharMap[6]
                = new Character[]{'m', 'n', 'o'};
        numberToCharMap[7]
                = new Character[]{'p', 'q', 'r', 's'};
        numberToCharMap[8]
                = new Character[]{'t', 'u', 'v'};
        numberToCharMap[9]
                = new Character[]{'w', 'x', 'y', 'z'};
    }
    public static void main(String[] args) {
        System.out.println("Please Enter a Phone number : ");
        Scanner scanner = new Scanner(System.in);
        String phoneNumber = scanner.next();

        // Function call
        printWords(phoneNumber);
    }

    private static void printWords(String phoneNumber) {

        char[] numbers = phoneNumber.toCharArray();
        int[] integers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            integers[i] = Integer.parseInt(String.valueOf(numbers[i]));
        }

        generateNumberToCharMap();
        List<String> stringList = printWords(integers, integers.length, 0, "");

        stringList.forEach(System.out::println);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(phoneNumber+".txt"))) {
            stringList.forEach(string -> {
                try {
                    writer.write(string + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private static List<String> printWords(int[] numbers, int len, int numIndex, String s) {
        if (len == numIndex) {
            return new ArrayList<>(Collections.singleton(s));
        }

        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < numberToCharMap[numbers[numIndex]].length; i++) {
            String sCopy = String.copyValueOf(s.toCharArray());

            sCopy = sCopy.concat(numberToCharMap[numbers[numIndex]][i].toString());

            stringList.addAll(printWords(numbers, len, numIndex + 1, sCopy));
        }
        return stringList;
    }

}
