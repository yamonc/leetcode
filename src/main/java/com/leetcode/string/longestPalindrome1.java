package com.leetcode.string;

/**
 * @Author yamon
 * @Date 2021-04-09 20:44
 * @Description
 * @Version 1.0
 */
public class longestPalindrome1 {
    public String longestPalindrome(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new longestPalindrome1().longestPalindrome("ababa"));
    }
}
