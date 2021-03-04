package com.leetcode.other;

/**
 * @Author yamon
 * @Date 2020-12-18 14:10
 * @Description 字符串回文
 * @Version 1.0
 */
public class Palindrome {
    public static boolean isPalindrome(String s){
        int N = s.length();
        for (int i = 0;i< N/2;i++){
            if (s.charAt(i)!= s.charAt(N-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isPalindrome("abba");
    }
}
