package com.leetcode.everyday;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-07-23 14:04
 * @Description
 * @Version 1.0
 */
public class IsCovered2 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (a1, a2) -> a1[0] - a2[0]);
        for(int[] range: ranges) {
            int l = range[0];
            int r = range[1];
            if(l <= left && left <= r) {
                left = r + 1;
            }
        }
        return left > right;
    }

    public static void main(String[] args) {
        int[][] arr ={
                {1,2},{3,4},{5,6}
        };
        System.out.println(new IsCovered2().isCovered(arr, 2, 5));
    }
}
