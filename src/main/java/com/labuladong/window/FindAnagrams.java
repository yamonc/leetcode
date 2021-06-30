package com.labuladong.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author yamon
 * @Date 2021-06-18 9:28
 * @Description 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0 抽象为输入一个串S，一个串T，找到S中所有T的排列，返回他们的起始索引。
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        //首先将p中所有的字符加入
        for (Character c : pChars){
            need.put(c, need.getOrDefault(c,0)+1);
        }
        //初始化变量
        int left,right,valid;
        left=right=valid=0;
        //开始比较
        while (right<sChars.length){
            //将c放入窗口内
            char c = sChars[right];
            //右移窗口
            right++;

            //进行窗口内的更新
            if (need.containsKey(c)){
                //添加到窗口内
                window.put(c, window.getOrDefault(c, 0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            //当窗口尺寸大于待比较的子串长度时：窗口缩小
            while (right-left>=pChars.length){
                //添加结果
                if (valid==need.size()){
                    ans.add(left);
                }
                //移除字符
                char d = sChars[left];
                left++;

                //
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(new FindAnagrams().findAnagrams("abab", "ab"));

    }
}
