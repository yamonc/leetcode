package com.leetcode.offerTupo;

/**
 * @Author yamon
 * @Date 2021-08-12 17:05
 * @Description 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * 示例 2:
 *
 * 输入: nums = [1,2,3], k = 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ZVAVXX
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;
        int mul = 1;
        int res = 0;

        while (right<nums.length){
            int num = nums[right];
            right++;
            if(num>k){
                left=right;
                mul = 1;
                continue;
            }
            mul = mul*num;
            while (mul>=k){
                mul = mul/nums[left];
                left++;
            }
            if (mul<k){
                res += (right-left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10,5,2,6};
        new NumSubarrayProductLessThanK().numSubarrayProductLessThanK(arr, 100);
    }
}