package com.newcode.offer;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-06-10 14:39
 * @Description 描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 示例1
 * 输入：
 * 3
 * 返回值：
 * 4
 * @Version 1.0
 */
public class JumpFloorII2 {
    private int[] memo;
    public int jumpFloorII(int target) {
        if(target==0 || target == 1){
            return 1;
        }
        int[] dp = new int[target+1];
        dp[0]=dp[1]=1;
        for (int i = 2; i <= target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i]+dp[j];
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        System.out.println(new JumpFloorII2().jumpFloorII(3));
    }
}
