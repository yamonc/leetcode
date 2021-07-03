package com.labuladong.highFrequencyInterview;

/**
 * @Author yamon
 * @Date 2021-07-02 10:14
 * @Description
 * @Version 1.0
 */
public class CanJump_I {
    public int canJump(int[] nums) {
        int n = nums.length;
        int end = 0, farthest = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args){
        int[] arr = {
                2,3,1,1,4
        };
        new CanJump_I().canJump(arr);
    }
}
