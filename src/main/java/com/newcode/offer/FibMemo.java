package com.newcode.offer;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-06-10 15:31
 * @Description 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class FibMemo {
    public int fib(int n) {
        if (n<1) return 0;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        //初始化
        return dp(memo, n);
    }
    public int dp(int[] memo, int n){
        //base case
        if (n == 1 || n == 2) return 1;
        //已经计算过了
        if (memo[n]!=-1){
            return memo[n];
        }
        memo[n] = dp(memo, n-1)+dp(memo, n-2);
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new FibMemo().fib(3));
    }
}
