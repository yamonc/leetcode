package com.leetcode.offerTupo;

import java.nio.charset.CharacterCodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author yamon
 * @Date 2021-08-18 15:44
 * @Description
 * @Version 1.0
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        for (char aT:tChars){
            need.put(aT, need.getOrDefault(aT,0)+1);
        }


        int left =0, right =0;
        int start = 0, len = Integer.MAX_VALUE;
        int valid = 0;

        while (right<s.length()){
            char c = sChars[right];
            right++;
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            while (valid == need.size()){
                if ((right-left)<len){
                    start = left;
                    len = right-left;
                }
                char d = sChars[left];
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }

        }

        return len == Integer.MAX_VALUE ? "":s.substring(start, start+len);
    }

    public static void main(String[] args) {
        new MinWindow().minWindow("ab", "a");
    }
}
