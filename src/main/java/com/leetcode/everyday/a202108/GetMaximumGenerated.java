package com.leetcode.everyday.a202108;

/**
 * @Author yamon
 * @Date 2021-08-23 14:30
 * @Description 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 * <p>
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 7
 * 输出：3
 * 解释：根据规则：
 * nums[0] = 0
 * nums[1] = 1
 * nums[(1 * 2) = 2] = nums[1] = 1
 * nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
 * nums[(2 * 2) = 4] = nums[2] = 1
 * nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
 * nums[(3 * 2) = 6] = nums[3] = 2
 * nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
 * 因此，nums = [0,1,1,2,1,3,2,3]，最大值 3
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：根据规则，nums[0]、nums[1] 和 nums[2] 之中的最大值是 1
 * 示例 3：
 * <p>
 * 输入：n = 3
 * 输出：2
 * 解释：根据规则，nums[0]、nums[1]、nums[2] 和 nums[3] 之中的最大值是 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-maximum-in-generated-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class GetMaximumGenerated {
    public int getMaximumGenerated(int n) {
        if (n==0){
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int ans = 1;
        for (int i = 2; i <= n; i++) {
             if (i%2==0){
                 //偶数
                 dp[i] = dp[i/2];
             }else{
                 dp[i] = dp[i/2]+dp[i/2+1];
             }
             ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        new GetMaximumGenerated().getMaximumGenerated(7);
    }
}
