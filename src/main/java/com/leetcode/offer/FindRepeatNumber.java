package com.leetcode.offer;

import java.util.*;

/**
 * @Author yamon
 * @Date 2021-03-30 10:20
 * @Description
 * @Version 1.0
 */
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)){
                return num;
            }
        }
        return -1;

    }

    public static void main(String[] args) {

        final int[] nums = {
                2,3,1,0,2,5,3
        };
        new FindRepeatNumber().findRepeatNumber(nums);
    }
}
