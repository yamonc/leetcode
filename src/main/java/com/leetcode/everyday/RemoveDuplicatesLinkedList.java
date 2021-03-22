package com.leetcode.everyday;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author yamon
 * @Date 2021-03-09 9:04
 * @Description
 * @Version 1.0
 */
public class RemoveDuplicatesLinkedList {


    public String removeDuplicates(String S) {

        int i = 0, j = 0, n = S.length();
        char[] res = S.toCharArray();
        while(j < n){
            res[i] = res[j];
            if(i > 0 && res[i - 1] == res[i]){
                i -= 2;
            }
            i++;
            j++;
        }
        return new String(res,0,i);

    }

    public static void main(String[] args) {
        new RemoveDuplicatesLinkedList().removeDuplicates("abbaca");
    }


}
