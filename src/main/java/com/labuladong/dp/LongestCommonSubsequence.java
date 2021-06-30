package com.labuladong.dp;

/**
 * @Author yamon
 * @Date 2021-06-25 10:12
 * @Description 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0 暴力法
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length()-1;
        int j = text2.length()-1;
        return dp(text1, text2, i, j);
    }
    public int dp(String t1, String t2, int i, int j){

        if (i==-1 || j == -1){
            return 0;
        }
        if (t1.charAt(i)==t2.charAt(j)){
            return dp(t1, t2, i-1,j-1)+1;
        }else{
            return Math.max(dp(t1, t2, i-1,j), dp(t1, t2, i, j-1));
        }
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("babcde", "ace"));
    }


}
