package com.study.all.study.dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestNonRepeatingChar {

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(getLongestChar(s));
    }


   public static Integer getLongestChar(String s) {
       char[] c = s.toCharArray();
       List<Integer> integers = new ArrayList<>();
       List<Character> characters = new ArrayList<>();
       for (char c1 :c) {
           if(characters.contains(c1)) {
               integers.add(characters.size());
               characters = new ArrayList<>();
           } else {
               characters.add(c1);
           }
       }
       integers.add(characters.size());
        return  Collections.max(integers);
    }

}
