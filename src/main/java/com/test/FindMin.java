package com.test;

/**
 * @Author yamon
 * @Date 2021-07-30 19:23
 * @Description
 * @Version 1.0
 */
public class FindMin {

    public int findMin(int[][] mapArray) {
        // write code here
        int m = mapArray.length;
        int n = mapArray[0].length;

        int[][] dp = new int[m][n];
        //动态规划初试条件
        dp[0][0] = mapArray[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + mapArray[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + mapArray[0][i];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = mapArray[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new FindMin().findMin(arr));
    }
}
