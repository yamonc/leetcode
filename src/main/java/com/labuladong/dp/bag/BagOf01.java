package com.labuladong.dp.bag;

import java.util.Arrays;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-06-23 9:12
 * @Description 有n 个物品，它们有各自的重量和价值，现有给定容量的背包，
 * 如何让背包里装入的物品具有最大的价值总和？
 * @Version 1.0
 */
public class BagOf01 {
    public int knapsack(int W, int N, int[] wt, int[] val) {
        int[][] dp = new int[N + 1][W + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, 0);
        }
        for (int i = 1; i <= N; i++) {
            dp[i][0]=0;
            for (int w = 1; w <= W; w++) {
                dp[0][w]=0;
                if (w - wt[i - 1] < 0) {
                    //当前背包装不下，选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    //装入背包或者不装入背包，择优
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt[i-1]] + val[i - 1]);
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        int[] wt = {1, 4, 3};
        int[] val = {15, 30, 20};
        System.out.println(new BagOf01().knapsack(4, 3, wt, val));
    }

}

