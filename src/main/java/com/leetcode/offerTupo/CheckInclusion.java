package com.leetcode.offerTupo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yamon
 * @Date 2021-08-17 10:58
 * @Description 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/MPnaiL
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        //首先将s1的字符放进need中，然后进行比较并收缩窗口
        for (char s1Char : s1Chars) {
            need.put(s1Char, 1);
        }
        //开始滑动窗口
        int left = 0, right = 0, valid = 0;
        while (right<s2.length()){
            char c = s2Chars[right];
            right++;

            //进行窗口内的数据更新
            if (need.containsKey(c)){
                //比较s2中的当前字符和s1中是否有一样的
                windows.put(c, windows.getOrDefault(c, 0)+1);
                if (windows.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            //开始收缩
            while (right-left>=s1.length()){
                if (valid==need.size()){
                    return true;
                }
                char d = s2Chars[left];
                left++;

                if (need.containsKey(d)){
                    if (windows.get(d).equals(need.get(d))){
                        valid--;
                    }
                    windows.put(d, windows.get(d)-1);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        new CheckInclusion().checkInclusion("ab", "eidbaooo");
    }
}
