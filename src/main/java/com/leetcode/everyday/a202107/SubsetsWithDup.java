package com.leetcode.everyday.a202107;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-03-31 8:49
 * @Description
 * @Version 1.0
 */
public class SubsetsWithDup {

    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int mask = 0; mask < (1<<n);++mask){
            t.clear();
            boolean flag = true;
            for(int i=0;i<n;i++){
                if ((mask & (1 << i)) != 0) {
                    if (i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
                        flag = false;
                        break;
                    }
                    t.add(nums[i]);
                }

            }
            if (flag){
                ans.add(new ArrayList<>(t));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        final int[] nums = {1, 2,2};
        System.out.println(new SubsetsWithDup().subsetsWithDup(nums));
    }
}
