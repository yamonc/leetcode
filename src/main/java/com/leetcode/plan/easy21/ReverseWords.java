package com.leetcode.plan.easy21;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-07-06 16:08
 * @Description 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *  
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class ReverseWords {
    public String reverseWords(String s) {
        final String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0;i<strings.length;i++){
            if(i==strings.length-1){
                final char[] chars = reverseString(strings[i].toCharArray());
                for (char aChar : chars) {
                    stringBuilder.append(aChar);
                }
            }else{
                final char[] chars = reverseString(strings[i].toCharArray());
                for (char aChar : chars) {
                    stringBuilder.append(aChar);
                }
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
    public char[] reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("Let's take LeetCode contest"));
    }
}
