package com.interviews;

import java.util.Arrays;
import java.util.Optional;

public class OtherTasks {

    public static void main(String[] args) {

        int[] nums = {1,-1, -3, 2,-3, 4, -5};

//        System.out.println(Arrays.toString(segregateNumbers(nums)));

        Optional<Integer> o = Optional.of(null);
        o.get();

        Optional<Integer> o1 = Optional.ofNullable(null);
        o.get();
    }

    public static int[] segregateNumbers(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length -1;

        while(leftIndex < rightIndex) {

            if ((nums[leftIndex] < 0 && nums[rightIndex] > 0)) {
                int temp = nums[leftIndex];
                nums[leftIndex] = nums[rightIndex];
                nums[rightIndex] = temp;
                leftIndex++;
                rightIndex--;
            } else if ((nums[leftIndex] > 0 && nums[rightIndex] > 0)) {
                leftIndex++;
            } else if (nums[leftIndex] < 0 && nums[rightIndex] < 0) {
                rightIndex--;
            } else {
                rightIndex--;
                leftIndex++;
            }
        }
        return nums;
    }

}
