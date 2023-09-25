package com.study.all.study.dsa.array.delete;

import java.util.HashMap;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
       // map.containsKey()
    }

    public static int removeDuplicates(int[] nums) {
        int index = 1;
        int prev = nums[0];
        //[0,0,1,1,1,2,2,3,3,4]

        for(int i = 1; i<nums.length; i++) {

            if(nums[i] != prev) {
                nums[index] = nums[i];
                prev = nums[i];
                index++;
            }

        }
        return index;
    }
}
