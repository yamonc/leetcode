package com.leetcode.offerTupo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yamon
 * @Date 2021-08-14 15:37
 * @Description 定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 * <p>
 *  
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
 * 示例 2 :
 * <p>
 * 输入:nums = [1,2,3], k = 3
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/QTMn0o
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        //前缀和
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        //0出现的次数为1次
        map.put(0, 1);
        int ans = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int targetSum = sum-k;
            if (map.containsKey(targetSum)){
                ans += map.get(targetSum);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SubarraySum().subarraySum(new int[]{1,1,1}, 2));
    }
}
