package com.leetcode.everyday;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author yamon
 * @Date 2021-03-10 9:33
 * @Description
 * @Version 1.0
 */
public class Calculate {
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i=0;
        while (i<n){
            if (s.charAt(i)=='+'){
                i++;
            }else if(s.charAt(i)=='-'){
                sign=-ops.peek();
                i++;
            }else if(s.charAt(i)=='('){
                ops.push(sign);
                i++;
            }else if(s.charAt(i) == ')'){
                ops.pop();
                i++;
            }else {
                long num=0;
                while (i<n && Character.isDigit(s.charAt(i))){
                    num = num*10+s.charAt(i)-'0';
                    i++;
                }
                ret+=sign*num;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        new Calculate().calculate("(1+(4+5+2)-3)+(6+8)");
    }
}
