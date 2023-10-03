package com.study.all.study.dsa.twodarray;

public class MinSizeSubArraySum {


    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};

        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = Integer.MAX_VALUE, sum = 0, start = 0, end = 0;
        while(end < nums.length) {
            sum += nums[end];
            while(sum >= target) {
                res = Math.min(res, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
