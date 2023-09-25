package com.study.all.study.dsa.array;

import java.util.HashMap;

public class MajorityElementsInArray {

    public static void main(String[] args) {

    //    int[] nums = {1,3,4,3,3,3,3,5,4,3};
        int[] nums = {1};
        System.out.println(findMajority(nums));
    }

    public static int findMajority(int[] nums) {
        int majority = nums.length / 2;
        HashMap<Integer, Integer> numberCountMap = new HashMap<>();

        if (nums.length > 1) {
            for (int i = 0; i < nums.length; i++) {
                if (numberCountMap.containsKey(nums[i])) {
                    numberCountMap.put(nums[i], numberCountMap.get(nums[i]) + 1);
                    if (numberCountMap.get(nums[i]) > majority) {
                        return nums[i];
                    }
                } else {
                    numberCountMap.put(nums[i], 1);
                }
            }

            return 0;

        } else {
            return nums[0];
        }
    }
}
