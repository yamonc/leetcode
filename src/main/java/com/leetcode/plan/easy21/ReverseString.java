package com.leetcode.plan.easy21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-07-06 15:50
 * @Description
 * @Version 1.0
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] arr = {'h','e','l','l','o'};
        new ReverseString().reverseString(arr);
    }
}
