package com.leetcode.compeet.comp;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author yamon
 * @Date 2021-05-30 20:39
 * @Description
 * @Version 1.0
 */
public class CountGoodSubstrings {
    public int countGoodSubstrings(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int left = 0;
        int right = 0;
        int count=0;
        for (int i = 0; i < len-2; i++) {
            right=left+2;
            String substring = s.substring(left, right+1);
            for (int j = 0; j<substring.length();j++){
                if (!set.contains(substring.charAt(j))){
                    //如果不包含，则加1
                    set.add(substring.charAt(j));
                }else{
                    break;
                }
            }
            if (set.size()==3){
                count++;
            }
            set.clear();
            left=left+1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountGoodSubstrings().countGoodSubstrings("xyzzaz"));
    }
}
