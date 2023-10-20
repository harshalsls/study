package com.study.all.study.dsa.twodarray;

public class MinSizeSubArraySum {


    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,100,4,3};

        System.out.println(minSubArrayLenWithTheSmartyPants(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(j = 0; j < nums.length; j++) {
            sum = sum + nums[j];
            if(sum >= target)  {

                if(min > Math.min(min, (j-i) +1)) {
                    min = (j - i) + 1;
                }
                i++;
                j = i - 1;
                sum = 0;


            }
        }

        if(min < Integer.MAX_VALUE) {
            return min;
        } else {
            return 0;
        }
    }




    public static int minSubArrayLenWithTheSmartyPants(int target, int[] nums) {

        int i = 0;
        int mini = Integer.MAX_VALUE;
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                mini = Math.min(mini, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }

        return mini == Integer.MAX_VALUE ? 0 : mini;
    }




}
