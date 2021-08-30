package com.leetcode.everyday.a202108;

import com.leetcode.offer.ReverseWords;

import java.nio.charset.CharacterCodingException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author yamon
 * @Date 2021-08-19 17:08
 * @Description 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * <p>
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "hello"
 * 输出："holle"
 * 示例 2：
 * <p>
 * 输入：s = "leetcode"
 * 输出："leotcede"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class ReverseVowels {
    static char[] vowels = new char[]{'a','e','i','o','u'};
    static Set<Character> set = new HashSet<>();
    static {
        for (char c : vowels) {
            set.add(c);
            set.add(Character.toUpperCase(c));
        }
    }

    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (set.contains(cs[l]) && set.contains(cs[r])) {
                swap(cs, l++, r--);
            } else {
                if (!set.contains(cs[l])) {
                    l++;
                }
                if (!set.contains(cs[r])) {
                    r--;
                }
            }
        }
        return String.valueOf(cs);

    }
    void swap(char[] cs, int l, int r) {
        char c = cs[l];
        cs[l] = cs[r];
        cs[r] = c;
    }


    public static void main(String[] args) {
        System.out.println(new ReverseVowels().reverseVowels("a."));
    }
}
