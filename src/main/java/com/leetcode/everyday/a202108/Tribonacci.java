package com.leetcode.everyday.a202108;

/**
 * @Author yamon
 * @Date 2021-08-08 14:21
 * @Description 泰波那契序列 Tn 定义如下： 
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class Tribonacci {
    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        if (n==1 || n==2){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = dp[2] = 1;
        for(int i =3;i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Tribonacci().tribonacci(1));
    }
}
