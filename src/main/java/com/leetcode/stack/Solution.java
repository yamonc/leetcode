package com.leetcode.stack;

import java.util.Stack;

/**
 * @Author yamon
 * @Date 2020-09-07 20:45
 * @Description
 * @Version 1.0
 */
public class Solution {
    private static int num=10;
    private static int a;
    public static void test(){
        a=1;
    }



    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()){
            if (c=='('){
                stack.push(')');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else if(stack.isEmpty()|| c!=stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        final boolean valid = isValid("(}");
        System.out.println(valid);
    }
}
