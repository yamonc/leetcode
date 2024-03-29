package com.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yamon
 * @Date 2021-08-06 17:06
 * @Description 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0 滑动窗口
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int ans = Integer.MIN_VALUE;
        //创建窗口
        Map<Character, Integer> window = new HashMap<>();
        char[] chars = s.toCharArray();
        int left=0, right =0;
        while (right<chars.length){
            //增大窗口
            char c = chars[right];
            right++;
            window.put(c, window.getOrDefault(c, 0)+1);
            while (window.get(c)>1){
                char d= chars[left];
                left++;
                window.put(d, window.getOrDefault(d, 0)-1);
            }
            ans = Math.max(ans, right-left);
        }
        return ans;
    }

    public static void main(String[] args) {
        new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb");
    }
}
