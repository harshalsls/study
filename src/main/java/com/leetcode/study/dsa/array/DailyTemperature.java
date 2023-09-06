package com.leetcode.study.dsa.array;

import java.util.Arrays;

public class DailyTemperature {

    public static void main(String[] args) {
        //int[] temps = {73,74,75,71,69,72,76,73};
        int[] temps = {30,60,90};
        System.out.println(Arrays.toString(getTheOutput(temps)));
    }
    public static int[] getTheOutput(int[] temps) {
        int arrayLength = temps.length;
        int[] outputArr = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {

            int count = 0;
            for (int j = i; j < arrayLength; j++) {
                if (temps[j] > temps[i]) {
                    outputArr[i] = count;
                    break;
                }
                count++;
            }
        }
        return outputArr;
    }
}
