package com.leetcode.offerTupo;

import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author yamon
 * @Date 2021-08-17 13:30
 * @Description 给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 变位词 指字母相同，但排列不同的字符串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
 *  示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/VabMRr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character,Integer> windows = new HashMap<>();

        for (char aP: pChars){
            need.put(aP, 1);
        }

        int left=0, right =0, valid = 0;
        while (right<s.length()){
            //c放入window中
            char c = sChars[right];
            right++;

            //进行窗口内的更新
            if (need.containsKey(c)){
                windows.put(c, windows.getOrDefault(c, 0)+1);
                if (windows.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            //当窗口尺寸大于待比较的子串长度的时候，窗口缩小，更新窗口
            while (right-left >= pChars.length){
                if (valid==need.size()){
                    ans.add(left);
                }
                char d = sChars[left];
                left++;
                if (need.containsKey(d)){
                    //删除need
                    if (windows.get(d).equals(need.get(d))){
                        valid--;
                    }
                    windows.put(d, windows.get(d)-1);
                }
            }
        }
        return ans;
    }
}
