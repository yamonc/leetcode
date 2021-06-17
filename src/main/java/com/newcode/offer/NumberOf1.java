package com.newcode.offer;

import java.util.HashMap;

/**
 * @Author yamon
 * @Date 2021-06-12 16:34
 * @Description
 * @Version 1.0
 */
public class NumberOf1 {

    public int NumberOf1(int n) {
        if (n==0){
            return 0;
        }
        String s = Integer.toBinaryString(n);
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            if (!map.containsKey(aChar)){
                map.put(aChar,1);
            }else{
                map.put(aChar, map.get(aChar)+1);
            }
        }
        return map.get('1');
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1().NumberOf1(0));
    }
}
