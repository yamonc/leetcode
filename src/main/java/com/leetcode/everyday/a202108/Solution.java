package com.leetcode.everyday.a202108;

/**
 * @Author yamon
 * @Date 2021-08-30 14:22
 * @Description
 * @Version 1.0
 */
public class Solution {
    int[] sum;

    public Solution(int[] w) {
        int n = w.length;
        sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + w[i - 1];
        }
    }

    public int pickIndex() {
        int n = sum.length;
        int t = (int) (Math.random() * sum[n - 1]) + 1;
        int l = 1, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (sum[mid] >= t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r - 1;
    }

}
