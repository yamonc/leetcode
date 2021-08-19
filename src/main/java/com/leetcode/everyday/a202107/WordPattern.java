package com.leetcode.everyday.a202107;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yamon
 * @Date 2020-12-16 9:07
 * @Description
 * @Version 1.0
 */
public class WordPattern {
    public static boolean solution(String pattern, String s) {
        Map<String,Character> str2ch = new HashMap<>();
        Map<Character, String> cha2str = new HashMap<>();
        int m = s.length();
        int i = 0;
        for (int p = 0;p < pattern.length();++p){
            char ch = pattern.charAt(p);
            if (i >=m){
                return false;
            }
            int j = i;
            while (j<m&&s.charAt(j)!=' '){
                j++;
            }
            String temp = s.substring(i,j);
            if (str2ch.containsKey(temp) && str2ch.get(temp) != ch){
                return false;
            }
            if (cha2str.containsKey(ch) && !temp.equals(cha2str.get(ch))){
                return false;
            }
            str2ch.put(temp,ch);
            cha2str.put(ch,temp);
            i = j+1;
        }
        return i>=m;
    }

    public static void main(String[] args) {
        solution("abba","cat dog dog cat");
    }
}
