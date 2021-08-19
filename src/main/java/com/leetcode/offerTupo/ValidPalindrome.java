package com.leetcode.offerTupo;

/**
 * @Author yamon
 * @Date 2021-08-18 16:18
 * @Description 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "aba"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "abca"
 * 输出: true
 * 解释: 可以删除 "c" 字符 或者 "b" 字符
 * 示例 3:
 *
 * 输入: s = "abc"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/RQku0D
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class ValidPalindrome {
    private boolean isPalindrome(String s, int left, int right){
        while (left<right){
            if (s.charAt(left++)!=s.charAt(right--)){
                return false;
            }

        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while (left<right){
            if (s.charAt(left)!=s.charAt(right)){
                //有一次删除的机会，不相等的时候删除左边或者删除右侧
                if (isPalindrome(s, left+1, right)|| isPalindrome(s, left, right-1)){
                    return true;
                }else {
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        new ValidPalindrome().validPalindrome("abca");

    }
}
