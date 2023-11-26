package com.study.all.study.dsa;

public class CheckAlphabetInSequence {

    public static void main(String[] args) {
        System.out.println(checkSequence("abcdefghijkll"));
    }

    public static boolean checkSequence(String str) {
        char[] alphabets = str.toCharArray();

        for (int i = 0; i < alphabets.length-1; i++) {

            if(alphabets[i+1] - alphabets[i] > 1) {
                System.out.println("Failed Sequence " + alphabets[i] +" and " + alphabets[i+1]);
                return false;
            }
        }
        return true;
    }
}
