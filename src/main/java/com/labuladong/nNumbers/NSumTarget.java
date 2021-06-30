package com.labuladong.nNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-06-22 10:42
 * @Description n 个数之和模板
 * @Version 1.0
 */
public class NSumTarget {
    List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        Arrays.sort(nums);
        int sz = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        //至少是2 sum， 且数组大小不应该小于n
        if (n < 2 || sz < n) {
            return res;
        }
        if (n==2){
            //双指针
            int lo = start, hi = sz-1;
            while (lo<hi){
                int sum = nums[lo]+nums[hi];
                int left = nums[lo];
                int right = nums[hi];
                if (sum<target){
                    while (lo<hi && nums[lo]==left) {
                        lo++;
                    }
                }else if(sum > target){
                    while (lo <hi && nums[hi]==right){
                        hi--;
                    }
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(left);
                    list.add(right);
                    res.add(list);
                    //去重
                    while (lo<hi && nums[lo] == left) {
                        lo++;
                    }
                    while (lo<hi && nums[hi] == right){
                        hi--;
                    }
                }

            }
        }else{
            // n>2的时候，递归计算（n-1）sum的结果
            for (int i = start; i < sz; i++) {
                List<List<Integer>> sub = nSumTarget(nums, n-1, i+1, target-nums[i]);
                for (List<Integer> integers : sub) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    res.add(list);
                }
                while (i<sz-1 && nums[i] ==nums[i+1]){
                    i++;
                }
            }
        }
        return res;
    }
}
