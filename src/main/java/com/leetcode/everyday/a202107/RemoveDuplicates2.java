package com.leetcode.everyday.a202107;

/**
 * @Author yamon
 * @Date 2021-04-06 9:21
 * @Description 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * @Version 1.0
 */
public class RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    public static void main(String[] args) {
        final int[] nums ={0,0,1,1,1,1,2,3,3};
        new RemoveDuplicates2().removeDuplicates(nums);
    }
}
