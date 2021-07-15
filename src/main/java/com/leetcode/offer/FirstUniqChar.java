package com.leetcode.offer;

import java.util.HashMap;

/**
 * @Author yamon
 * @Date 2021-07-15 10:35
 * @Description 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        if(s.length()==0){
            return ' ';
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
                //如果里面已经有了，则--
                map.put(s.charAt(i), map.get(s.charAt(i)-1));
            }else{
                //如果没有，则直接添加
                map.put(s.charAt(i), 1);
            }
        }
        for(char c : s.toCharArray()){
            if(map.get(c)!=null){
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar("abaccdeff"));
    }
}
