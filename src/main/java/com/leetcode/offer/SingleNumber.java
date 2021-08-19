package com.leetcode.offer;

/**
 * @Author yamon
 * @Date 2021-07-28 15:42
 * @Description
 * @Version 1.0
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,3,3};
        System.out.println(new SingleNumber().singleNumber(arr));
    }
}
