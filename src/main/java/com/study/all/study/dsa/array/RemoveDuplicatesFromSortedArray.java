package com.study.all.study.dsa.array;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {9,8,7,7,6,5,4,4,3,2,1};
        removeDuplicate(nums);
    }

    public static int removeDuplicate(int[] nums) {
        int index = 1;
        for(int i=1; i<nums.length; i++ ) {
            if(nums[i] != nums[i-1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }



}
