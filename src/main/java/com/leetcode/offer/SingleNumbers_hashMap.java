package com.leetcode.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author yamon
 * @Date 2021-07-28 15:13
 * @Description
 * @Version 1.0
 */
public class SingleNumbers_hashMap {
    public int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int[] ans = new int[2];
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            if(entry.getValue()<2){
                ans[idx++] = entry.getKey();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr ={4,1,4,6};
        System.out.println(Arrays.toString(new SingleNumbers_hashMap().singleNumbers(arr)));
    }
}
