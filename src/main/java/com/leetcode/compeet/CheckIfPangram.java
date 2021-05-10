package com.leetcode.compeet;

import java.util.HashSet;

/**
 * @Author yamon
 * @Date 2021-04-18 10:51
 * @Description 全字母句 指包含英语字母表中每个字母至少一次的句子。
 *
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 *
 * 如果是，返回 true ；否则，返回 false 。
 * @Version 1.0
 */
public class CheckIfPangram {
    public static boolean checkIfPangram(String sentence) {
        if (sentence.length()<26){
            return false;
        }
        HashSet hashSet = new HashSet();
        char[] chars = sentence.toCharArray();
        for (char aChar : chars) {
            hashSet.add(aChar);
        }
        return 26 ==hashSet.size();
    }

    public static void main(String[] args) {
        System.out.println(CheckIfPangram.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }
}
