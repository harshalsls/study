package com.leetcode.study;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {-3,-2,-1,0,1,2,3,4,5,6,7};
        int target = 6;
        System.out.println(search(nums, target));
    }
}
