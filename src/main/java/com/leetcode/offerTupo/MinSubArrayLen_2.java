package com.leetcode.offerTupo;

/**
 * @Author yamon
 * @Date 2021-08-14 10:59
 * @Description 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/2VG8Kg
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class MinSubArrayLen_2 {

    public int minSubArrayLen(int target, int[] nums) {
        int lo =0, hi = 0, sum = 0,min = Integer.MAX_VALUE;
        while (hi<nums.length){
            sum += nums[hi++];
            while (sum>=target){
                min = Math.min(min, hi-lo);
                sum -= nums[lo];
                lo++;
            }
        }
        return min == Integer.MAX_VALUE?0:min;
    }

    public static void main(String[] args) {
        System.out.println(new MinSubArrayLen_2().minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }


}
