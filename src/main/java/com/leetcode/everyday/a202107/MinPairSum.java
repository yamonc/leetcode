package com.leetcode.everyday.a202107;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-07-20 10:13
 * @Description 一个数对 (a,b) 的 数对和 等于 a + b 。最大数对和 是一个数对数组中最大的 数对和 。
 * <p>
 * 比方说，如果我们有数对 (1,5) ，(2,3) 和 (4,4)，最大数对和 为 max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8 。
 * 给你一个长度为 偶数 n 的数组 nums ，请你将 nums 中的元素分成 n / 2 个数对，使得：
 * <p>
 * nums 中每个元素 恰好 在 一个 数对中，且
 * 最大数对和 的值 最小 。
 * 请你在最优数对划分的方案下，返回最小的 最大数对和 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,5,2,3]
 * 输出：7
 * 解释：数组中的元素可以分为数对 (3,3) 和 (5,2) 。
 * 最大数对和为 max(3+3, 5+2) = max(6, 7) = 7 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,5,4,2,4,6]
 * 输出：8
 * 解释：数组中的元素可以分为数对 (3,5)，(4,4) 和 (6,2) 。
 * 最大数对和为 max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class MinPairSum {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n-i-1];
            ans = Math.max(ans, a+b);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,4,2,4,6};
        System.out.println(new MinPairSum().minPairSum(arr));
    }

}
