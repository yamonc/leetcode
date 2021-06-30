package com.labuladong.gupiao;

/**
 * @Author yamon
 * @Date 2021-06-18 15:57
 * @Description 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class MaxProfit_free_1 {

    public int maxProfit(int[] prices) {
        if (prices.length==0){
            return 0;
        }
        int n = prices.length;
        /**
         *定义三种状态:
         * dp[i][0] :手上持有股票的最大化
         * dp[i][1] : 手上不持有股票，并且处于冷冻期的累计最大收益
         * dp[i][2] : 手上不持有股票，并且不处于冷冻期的累计最大收益
         */
        int[][] dp = new int[n][3];

        //base case
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            //动态转移方程
            //今天没有股票:前一天就没有股票或者前一天有股票，但是今天抛售了
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]-prices[i]);

            dp[i][1] = dp[i-1][0]+prices[i];
            //今天持有股票：前一天有股票或者前两天没有股票，购买了股票
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
        }
        return Math.max(dp[n-1][1], dp[n-1][2]);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(new MaxProfit_free_1().maxProfit(arr));
    }
}
