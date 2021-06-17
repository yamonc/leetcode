package com.leetcode.other.recall;

/**
 * @Author yamon
 * @Date 2021-06-05 10:57
 * @Description 0-1背包问题
 * @Version 1.0
 */
public class BagQuestion {
    public int maxW = Integer.MAX_VALUE;

    public void f(int i, int cw, int[] items, int n, int w) {
        if (cw == w || i == n) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        f(i + 1, cw, items, n, w);
        if (cw + items[i] <= w) {
            f(i + 1, cw + items[i], items, n, w);
        }
    }
}
