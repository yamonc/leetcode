package com.labuladong.dp.bag;

/**
 * @Author yamon
 * @Date 2021-06-23 14:50
 * @Description
 * @Version 1.0
 */
public class Change {

    public int change(int amount, int[] coins){
        int[] dp = new int[amount+1];
        dp[0] =1;
        for (int coin : coins){
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5};
        System.out.println(new Change().change(5, arr));
    }
}
