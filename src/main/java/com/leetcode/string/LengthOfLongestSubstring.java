package com.leetcode.string;

import java.util.HashMap;

/**
 * @Author yamon
 * @Date 2021-05-28 19:59
 * @Description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 滑动窗口解题
 * @Version 1.0
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max=0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                left=Math.max(left, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max, i-left+1);
        }
        return max;
    }

    public static void main(String[] args) {
        new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb");
    }
}
