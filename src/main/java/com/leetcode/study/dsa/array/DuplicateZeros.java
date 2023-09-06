package com.leetcode.study.dsa.array;

public class DuplicateZeros {

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};
        DuplicateZeros duplicateZeros = new DuplicateZeros();
        duplicateZeros.duplicateZero(arr);
    }

    public int[] duplicateZero(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 2; j >= i; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[i] = 0;
                i++;
            }
        }
        return arr;
    }

}
