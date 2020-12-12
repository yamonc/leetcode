package com.leetcode.stack;

import org.apache.logging.log4j.util.StringBuilders;

/**
 * @Author yamon
 * @Date 2020-12-12 9:21
 * @Description
 * @Version 1.0
 */
public class BackspaceCompare {
    public static boolean solution(String S, String T) {
        return build(S).equals(build(T));
    }

    private static String build(String str) {
        StringBuffer ret = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (ch!='#'){
                ret.append(ch);
            }else {
                if (ret.length()>0){
                    ret.deleteCharAt(ret.length()-1);
                }
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        solution("ab#c","ad#c");
    }
}
