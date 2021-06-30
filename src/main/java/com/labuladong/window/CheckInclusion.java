package com.labuladong.window;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yamon
 * @Date 2021-06-17 16:35
 * @Description 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
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
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 可以抽象成为给定一个S和一个T，请问S中是否存在一个子串，包含T中所有的字符而不含其他字符？
 * @Version 1.0
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        //首先将包含的字符添加到need中
        for (Character c : s1Chars) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        //初始化变量
        int left,right,valid;
        left=right=valid=0;
        while (right< s2Chars.length){
            char c = s2Chars[right];
            right++;

            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            //左侧收缩
            while (right-left>= s1Chars.length){
                if (valid==need.size()){
                    return true;
                }
                char d = s2Chars[left];
                left++;

                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CheckInclusion().checkInclusion("ab", "eidbaooo"));
    }
}
