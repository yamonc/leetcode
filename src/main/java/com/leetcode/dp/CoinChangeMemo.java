package com.leetcode.dp;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-06-12 10:52
 * @Description 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 2.0 使用Memo
 */
public class CoinChangeMemo {


    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, 0);
        if (amount < 1) {
            return 0;
        }
        return backtrack(coins, amount, memo);
    }

    private int backtrack(int[] coins, int amount, int[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        if (memo[amount] != 0) {
            return memo[amount];
        }
        for (int i = 0; i < coins.length; i++) {
            int res = backtrack(coins, amount - coins[i], memo);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        memo[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[amount];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        System.out.println(new CoinChangeMemo().coinChange(arr, 100));
    }
}
