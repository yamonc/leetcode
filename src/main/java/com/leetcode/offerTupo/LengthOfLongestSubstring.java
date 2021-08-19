package com.leetcode.offerTupo;

import java.nio.charset.CharacterCodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author yamon
 * @Date 2021-08-17 13:46
 * @Description 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wtcaE1
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        Map<Character, Integer> window = new HashMap<>();
        int left=0, right = 0;
        int ans = Integer.MIN_VALUE;
        while (right<s.length()){
            char c = s.charAt(right);
            right++;
            //窗口更新
            window.put(c, window.getOrDefault(c, 0)+1);
            //窗口缩减
            while (window.get(c)>1){
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d)-1);
            }
            ans = Math.max(ans, right-left);
        }
        return ans;
    }

    public static void main(String[] args) {
        new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcab");
    }

}
