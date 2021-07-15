package com.test;

import java.util.*;

/**
 * @Author yamon
 * @Date 2021-07-03 15:35
 * @Description
 * @Version 1.0
 */
public class Test1 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        //首先计算出前缀和
        int n = nums.length;
        //前缀和，前缀和出现的次数
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        int ans = 0;
        int sumi=0;
        for(int i = 0;i<n;i++){
            sumi+=nums[i];
            //这是我们想找的前缀和[0,j]
            int sumj = sumi-goal;
            //如果前面有这个前缀和，则直接更新答案
            if(preSum.containsKey(sumj)){
                ans += preSum.get(sumj);
            }
            //吧前缀和加入并记录
            preSum.put(sumi, preSum.getOrDefault(sumi, 0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1};
        System.out.println(new Test1().numSubarraysWithSum(arr, 2));
    }
}
