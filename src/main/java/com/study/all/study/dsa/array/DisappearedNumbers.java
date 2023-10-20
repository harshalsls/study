package com.study.all.study.dsa.array;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {

    public static void main(String[] args) {
        int[] nums = {1,3,2,7,8,2,3,4};
        findDisappearedNumbers(nums);
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i : nums) {
            int index = Math.abs(i);
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
