package com.leetcode.study.dsa;

import java.util.HashMap;

public class CodingClng {
    //1 stock, get max profit bu buying and selling,
    // 100 = 180,  80
    // 260 =
    //
    // index profit
    //
    //
    // {100, 180, 260, 310, 40, 535, 695}

    public static void main(String[] args) {
        int[] nums = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(getMaxProfit(nums));
    }

    public static int getMaxProfit(int[] nums)  {

        HashMap<Integer, Integer> profitMap = new HashMap<>();

        int lowest = 0;
        int lowestIndex = 0;
        int highest = 0;


        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < nums[i+1] && lowest > nums[i]) {
                lowest = nums[i];
                lowestIndex = i;
            } else if(nums[i+1] > nums[i] && nums[i+1] < lowest) {
                profitMap.put(lowestIndex,i);
                highest = nums[i];
                lowest = nums[i+1];
                lowestIndex = i+1;
            }
        }
        int profit = 0;
        for (int key:profitMap.keySet()) {
            profit += profitMap.get(key);
        }
        return profit;
    }
}
