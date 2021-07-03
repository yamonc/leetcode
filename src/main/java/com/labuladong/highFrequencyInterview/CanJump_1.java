package com.labuladong.highFrequencyInterview;

/**
 * @Author yamon
 * @Date 2021-07-02 10:14
 * @Description
 * @Version 1.0
 */
public class CanJump_1 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for(int i = 0;i< n-1;i++){
            //不断计算能跳到的最远距离
            farthest = Math.max(farthest, i+nums[i]);
            //可能碰到0，不挑
            if(farthest <= i){
                return false;
            }
        }
        return farthest >=n-1;
    }

    public static void main(String[] args){
        int[] arr = {
                2,3,1,1,4
        };
        new CanJump_1().canJump(arr);
    }
}
