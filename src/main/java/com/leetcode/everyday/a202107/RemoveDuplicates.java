package com.leetcode.everyday.a202107;

import java.util.Stack;

/**
 * @Author yamon
 * @Date 2021-03-09 9:04
 * @Description
 * @Version 1.0
 */
public class RemoveDuplicates {


    public String removeDuplicates(String S) {

        final char[] chars = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        //循环添加到栈中，如果待添加元素和栈顶元素相同，取消
        for (char aChar : chars) {
            if (!stack.isEmpty() && aChar==stack.peek()){
                //出栈，不添加
                stack.pop();
                continue;
            }else{
                //加入站
                stack.push(aChar);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new RemoveDuplicates().removeDuplicates("abbaca");
    }


}
