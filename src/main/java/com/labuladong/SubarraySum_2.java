package com.labuladong;

import java.util.HashMap;

/**
 * @Author yamon
 * @Date 2021-06-30 9:24
 * @Description 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0 使用hashMap优化
 */
public class SubarraySum_2 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        //记录前缀和 前缀和出现的次数
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        //构造前缀和
        int ans = 0, sumI = 0;
        for(int i = 0;i<n;i++){
            sumI += nums[i];
            //前缀和nums[0,j]
            int sumJ = sumI-k;
            //如果前面有这个前缀和，则直接更新答案
            if(preSum.containsKey(sumJ)){
                ans += preSum.get(sumJ);
            }
            //把前缀和nums[0,i]加入并记录出现的次数
            preSum.put(sumI, preSum.getOrDefault(sumI, 0)+1);
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {
                1,2,3,4,5
        };
        System.out.println(new SubarraySum_2().subarraySum(arr, 7));
    }
}
