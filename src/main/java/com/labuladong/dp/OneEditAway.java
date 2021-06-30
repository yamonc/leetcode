package com.labuladong.dp;

/**
 * @Author yamon
 * @Date 2021-06-24 14:44
 * @Description 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class OneEditAway {
    public boolean oneEditAway(String first, String second) {
        int firstLen = first.length();
        int secondLen = second.length();
        int[][] dp = new int[firstLen + 1][secondLen + 1];
        //当第一个字符串为""
        for (int j = 1; j <= secondLen; j++) {
            dp[0][j] = j;
        }
        //当第二个字符串为""
        for (int i = 1; i <= firstLen; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= firstLen; i++) {
            for (int j = 1; j <= secondLen; j++) {
                if (first.charAt(i-1) == second.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //有三种情况，删除，增加，替换(两个长度相等时候就进行替换)
                    //各种操作加一的最小值，就是最小编辑次数
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                }
            }
        }
        if(dp[firstLen][secondLen]>1){
            return false;
        }
        return true;
    }


}
