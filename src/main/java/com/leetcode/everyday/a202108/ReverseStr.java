package com.leetcode.everyday.a202108;

/**
 * @Author yamon
 * @Date 2021-08-20 14:38
 * @Description 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] sChars = s.toCharArray();
        int n = sChars.length;
        for (int l = 0; l < n; l = l + 2 * k) {
            int r = l + k - 1;
            reverse(sChars, l, Math.min(r, n - 1));
        }
        return String.valueOf(sChars);
    }

    private void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char c = chars[l];
            chars[l] = chars[r];
            chars[r] = c;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        new ReverseStr().reverseStr("abcdefg", 2);
    }
}
