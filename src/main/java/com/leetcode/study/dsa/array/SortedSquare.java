package com.leetcode.study.dsa.array;

public class SortedSquare {
    public static void main(String[] args) {
        SortedSquare a = new SortedSquare();
        int[] arr = {-200,-20,-10,0,10,50};
        a.sortedSquares(arr);
    }


    public int[] sortedSquares(int[] nums) {
        int[] answerArr = new int [nums.length];
        int answerIndex = nums.length -1 ;
        int leftIndex = 0;
        int rightIndex = nums.length-1;

        while(leftIndex<=rightIndex) {
            if(Math.abs(nums[leftIndex]) > Math.abs(nums[rightIndex])) {
                answerArr[answerIndex] = nums[leftIndex] * nums[leftIndex];
                leftIndex ++;
            } else {
                answerArr[answerIndex] = nums[rightIndex] * nums[rightIndex];
                rightIndex --;
            }
            answerIndex--;
        }
        return answerArr;

    }
}
