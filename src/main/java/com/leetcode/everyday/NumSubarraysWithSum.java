package com.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yamon
 * @Date 2021-07-08 9:57
 * @Description 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 *
 * 子数组 是数组的一段连续部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * 示例 2：
 *
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class NumSubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int res = 0;
        for(int num:nums){
            cnt.put(sum, cnt.getOrDefault(sum, 0)+1);
            sum+=num;
            res+= cnt.getOrDefault(sum-goal, 0);
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = {1,0,1,0,1};
        new NumSubarraysWithSum().numSubarraysWithSum(arr, 2);
    }

}
