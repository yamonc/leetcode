package com.leetcode.dp;

import java.util.HashMap;

/**
 * @Author yamon
 * @Date 2021-06-11 16:39
 * @Description 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 *
 * 输入：nums = [1], target = 1
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 2.0 备忘录优化
 */
public class FindTargetSumWaysMemo {
    int res = 0;
    HashMap<String, Integer> memo = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length==0){
            return 0;
        }

        return dp(nums, 0, target);
    }

    public int dp(int[] nums, int i, int rest){
        if (i==nums.length){
            if (rest==0){
                //凑出来target
                return 1;
            }
            return 0;
        }
        //转为字符串
        String key = i+","+rest;
        //避免重复计算
        if (memo.containsKey(key)){
            return memo.get(key);
        }
        //穷举
        res= dp(nums,i+1, rest-nums[i])+dp(nums, i+1, rest+nums[i]);
        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};

        System.out.println(new FindTargetSumWaysMemo().findTargetSumWays(arr, 3));
    }
}
