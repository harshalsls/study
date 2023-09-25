package com.study.all.study.dsa.array;

public class Array {
    int length;
    int filledCount = 0;
    private int[] arr;

    public Array(int length) {
        this.length = length;
        arr = new int[length];

    }

    public void insert(int i) {
        if (filledCount == arr.length) {
            int[] newArr = new int[arr.length * 2];

            for (int j = 0; j < arr.length; j++) {
                newArr[j] = arr[j];
            }
            arr = newArr;
        }
        if (filledCount < arr.length) {
            arr[filledCount] = i;
            filledCount++;
        }
    }

    public void removeAt(int index) {
        if (arr.length == index) {
            arr[index - 1] = 0;
        } else if (index < arr.length) {
            for (int i = index - 1; i <= arr.length; i++) {
                arr[i] = arr[i + 1];
            }
        }
    }

    public int indexOf(int i) {
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] == i) {
                return j;
            }
        }
        return -1;
    }
}
