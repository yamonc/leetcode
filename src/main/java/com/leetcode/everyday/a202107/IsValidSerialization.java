package com.leetcode.everyday.a202107;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author yamon
 * @Date 2021-03-12 8:43
 * @Description
 * @Version 1.0
 */

public class IsValidSerialization {

    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        while (i < n){
            if (stack.isEmpty()){
                return false;
            }
            if (preorder.charAt(i)==','){
                i++;
            }else if (preorder.charAt(i)=='#'){
                int top = stack.pop()-1;
                if (top > 0){
                    stack.push(top);
                }
                i++;
            }else{
                // 读取一个数字
                while (i < n&& preorder.charAt(i) != ','){
                    i++;
                }
                int top = stack.pop()-1;
                if (top>0){
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        new IsValidSerialization().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }
}
