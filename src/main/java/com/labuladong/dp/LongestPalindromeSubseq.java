package com.labuladong.dp;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-06-25 15:48
 * @Description 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 * <p>
 *  
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * "bbbab"
 * 输出:
 * <p>
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 * <p>
 * 示例 2:
 * 输入:
 * <p>
 * "cbbd"
 * 输出:
 * <p>
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        //dp数组全部初始化为0；
        int[][] dp = new int[n][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, 0);
        }
        //base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        //反着遍历保证正确的动态方程转移
        for (int i = n-1;i>=0;i--){
            for (int j = i+1; j < n; j++) {
                //装填转移方程
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromeSubseq().longestPalindromeSubseq("bbbab"));
    }
}
