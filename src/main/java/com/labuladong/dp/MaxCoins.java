package com.labuladong.dp;

/**
 * @Author yamon
 * @Date 2021-06-25 9:34
 * @Description 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * <p>
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * <p>
 * 求所能获得硬币的最大数量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * 输入：nums = [3,1,5,8]
 * 输出：167
 * 解释：
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * 示例 2：
 * <p>
 * 输入：nums = [1,5]
 * 输出：10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class MaxCoins {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        //添加两侧的虚拟气球
        int[] points = new int[n + 2];
        points[0] = points[n+1] = 1;
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i-1];

        }
        //base case
        int[][] dp = new int[n+2][n+2];
        //开始状态转移，i从下给上
        for (int i = n; i >= 0; i--) {
            //j从左给右
            for (int j = i+1; j < n+2; j++) {
                //最后戳破的是哪个气球
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j],dp[i][k]+dp[k][j]+points[i]*points[k]*points[j]);
                }
            }
        }
        return dp[0][n+1];
    }

}
