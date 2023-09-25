package com.study.all.study.dsa.array;

public class FindBracketPairs {

    public static void main(String[] args) {
        String s = "{assdd{dddd}}}dd";
        Integer numberOfValid = findValidPair(s);
        System.out.println(numberOfValid);
    }

    private static Integer findValidPair(String s) {
        int numOfBrackets = 0;
        int balanceOfBracket = 0;
        for (int i = 0; i < s.length(); i++) {
            if('{' ==s.charAt(i)) {
                numOfBrackets +=1;
                balanceOfBracket +=1;
            } else if ('}' == s.charAt(i)) {
                numOfBrackets +=1;
                balanceOfBracket -=1;
            }
        }

        return (numOfBrackets - Math.abs(balanceOfBracket)) / 2;
    }

}
