package com.leetcode.recurrence;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yamon
 * @Date 2021-04-26 21:04
 * @Description 使用hash
 * @Version 1.0
 */
public class TwoSum2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable=new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target-nums[i])){
                return new int[]{hashtable.get(target-nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        new TwoSum2().twoSum(arr,26);
    }
}
