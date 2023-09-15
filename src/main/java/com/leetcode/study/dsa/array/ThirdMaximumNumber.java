package com.leetcode.study.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThirdMaximumNumber {

    public static void main(String[] args) {
        int[] nums = {1,2,-2147483648};
      //  System.out.println(thirdMax(nums));

        List<Integer> integers = new ArrayList<>();




        Integer[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> collect = Arrays.stream(nums1).sorted(Comparator.comparingInt(value -> ((Integer) value % 2)).reversed()).collect(Collectors.toList());

        System.out.println(collect);

     //   System.out.println(findDisappearedNumbers(nums1));

    }

    public static int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        int i = 0;
        boolean isThirdMaxSet = false;



        while (i <= nums.length-1) {
            if(firstMax == nums[i] || secondMax ==  nums[i] || thirdMax == nums[i]) {
                i++;
                continue;
            }

            if(firstMax < nums[i]) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            } else if(secondMax < nums[i]) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if(thirdMax < nums[i]) {
                thirdMax = nums[i];
            }
            i++;
        }

        if(thirdMax == Long.MIN_VALUE ) {
            return (int) firstMax;
        }
        return (int) thirdMax;

    }

    // [1,2,3,4,5,6,7,8]

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
