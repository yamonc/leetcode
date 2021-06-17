package com.labuladong;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yamon
 * @Date 2021-06-17 15:14
 * @Description 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0 暴力解法
 */
public class MinWindow {

    public String minWindow(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character,Integer> need=new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (Character c: tChars){
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        int left,right;
        left=right=0;
        int valid = 0;
        //记录最小覆盖子串的起始索引及长度
        int start = 0,len = Integer.MAX_VALUE;
        while (right<sChars.length){
            //c是将移入窗口的字符
            char c = sChars[right];
            //右移窗口
            right++;
            //进行窗口的一系列更新
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            //判断左侧窗口是否要收缩
            while (valid == need.size()){
                //这里更新最小覆盖子串
                if ((right-left)<len){
                    start = left;
                    len = right-left;
                }
                //d是将移除窗口的字符
                char d = sChars[left];
                //左移窗口
                left++;
                //进行窗口内的更新
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }
        //返回最小覆盖子串
        return len == Integer.MAX_VALUE?"":s.substring(start, start+len);

    }

    public static void main(String[] args) {
        System.out.println(new MinWindow().minWindow("ADOBECODEBANC", "ABC"));
    }

}
