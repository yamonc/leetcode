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
public class JumpFloorII {
    private int[] memo;

    public int numWays(int n){
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return jump(n);
    }
    public int jump(int n){
        if (memo[n]!=-1){
            return memo[n];
        }
        if (n==0 || n==1){
            return 1;
        }
        memo[n] = (jump(n-1) + jump(n-2)) %1000000007;
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new JumpFloorII().numWays(3));
    }
}
