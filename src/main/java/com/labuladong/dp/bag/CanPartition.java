package com.labuladong.dp.bag;

import java.util.Arrays;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-06-23 9:41
 * @Description给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class CanPartition {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        //奇数不能分割
        if (sum %2!=0){
            return false;
        }
        int n = nums.length;
        sum =sum/2;
        boolean[][] dp = new boolean[n+1][sum+1];
        for (boolean[] booleans : dp) {
            Arrays.fill(booleans, false);
        }
        //base case
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j-nums[i-1]<0){
                    //背包不足，不能装入
                    dp[i][j] = dp[i-1][j];
                }else{
                    //装入或者不装入背包
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}
