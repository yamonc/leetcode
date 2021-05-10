package com.leetcode.string;

import java.util.HashSet;

/**
 * @Author yamon
 * @Date 2021-04-08 8:32
 * @Description 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * @Version 1.0
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 用于存放字符串
        HashSet<Character> hashSet = new HashSet<>();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!hashSet.contains(chars[i])) {
                hashSet.add(chars[i]);
            } else {
                //如果有，count++
                hashSet.remove(chars[i]);
                count++;
            }
        }
        return hashSet.isEmpty() ? count * 2 : count * 2 + 1;
    }

    public static void main(String[] args) {
        new LongestPalindrome().longestPalindrome("abccccdd");
    }
}
