package com.leetcode.dp;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-06-10 10:19
 * @Description
 * @Version 1.0
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        //找出dp数组中最大的数
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,3,4,2};
        System.out.println(new LengthOfLIS().lengthOfLIS(arr));
    }
}
