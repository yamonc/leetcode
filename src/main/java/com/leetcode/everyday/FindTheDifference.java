package com.leetcode.everyday;

/**
 * @Author yamon
 * @Date 2020-12-18 9:23
 * @Description
 * @Version 1.0
 */
public class FindTheDifference {
    public static char solution(String s,String t){
        char ans = t.charAt(t.length()-1);
        for (int i = 0; i < s.length(); i++) {
            ans ^= s.charAt(i);
            ans ^= t.charAt(i);

        }
        return ans;
    }

    public static void main(String[] args) {
        final char solution = solution("", "y");
        System.out.println(solution);

    }
}
