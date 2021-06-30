package com.labuladong.houseRobber;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-06-19 10:24
 * @Description 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0 引入memo
 */
public class RobI_2 {
    private int[] memo;
    public int rob(int[] nums) {
        memo=new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0, memo);
    }
    public int dp(int[] nums, int start, int[] memo){

        if (start>=nums.length){
            return 0;
        }
        //添加到memo中
        if (memo[start]!=-1){
            return memo[start];
        }
        int res = Math.max(dp(nums, start+1, memo), nums[start]+dp(nums, start+2, memo));
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,9,3,1};
        System.out.println(new RobI_2().rob(arr));
    }
}
