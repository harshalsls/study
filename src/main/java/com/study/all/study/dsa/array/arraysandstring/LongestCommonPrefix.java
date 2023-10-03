package com.study.all.study.dsa.array.arraysandstring;

import java.util.Objects;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] strs = {"caa","","a","acb"};
        "abcd".indexOf("a");
        System.out.println(longestCommonPrefix(strs));
    }


    public static String longestCommonPrefix(String[] strs) {
        int strsLength = strs.length;
        int stringLength = strs[0].length();
        int smallestIndex = 0;

        for(int i = 0; i < strsLength -1 ; i++) {
            if(strs[i].length() < strs[i+1].length()) {
                if( stringLength > strs[i].length()) {
                    stringLength = strs[i].length();
                    smallestIndex = i;
                }
            }
            else if (strs[i].length() > strs[i+1].length()) {
                if( stringLength > strs[i+1].length()) {
                    stringLength = strs[i + 1].length();
                    smallestIndex = i + 1;
                }
            }
        }

        if(strsLength == 1 || stringLength == 0 || strs[0].equals("")) {
            if(Objects.nonNull(strs[smallestIndex])) {
                return strs[smallestIndex];
            } else {
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stringLength; i++) {

            char alpha = strs[0].charAt(i);
            for(int j = 1; j < strsLength; j++) {

                if(!(alpha == strs[j].charAt(i))) {
                    return sb.toString();
                }
            }
            sb.append(alpha);
        }
        return sb.toString();

    }
}
