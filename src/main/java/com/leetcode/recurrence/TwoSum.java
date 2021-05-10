package com.leetcode.recurrence;

/**
 * @Author yamon
 * @Date 2021-04-26 21:04
 * @Description
 * @Version 1.0
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        new TwoSum().twoSum(arr,26);
    }
}
