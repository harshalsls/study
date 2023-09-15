package com.leetcode.study.dsa.array.arraysandstring;

public class LargestNumberAtLeastTwiceOfOthers {


    public static void main(String[] args) {

        int[] nums = {0,0,0,1};
        System.out.println(dominantIndex(nums));

    }

    public static int dominantIndex(int[] nums) {
        int max = 0;
        int maxIndex = 0;
        int secondMax = 0;

        if(nums[0] > nums[1]) {
            max = nums[0];
            maxIndex = 0;
            secondMax = nums[1];
        } else {
            max = nums[1];
            maxIndex = 1;
            secondMax = nums[0];
        }

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            }
        }

        if(max >= secondMax *2) {
            return maxIndex;
        } else {
            return -1;
        }

    }
}
