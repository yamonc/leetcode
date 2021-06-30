package com.labuladong.caculate;

import java.util.Stack;

/**
 * @Author yamon
 * @Date 2021-06-23 15:28
 * @Description 只能计算加减法，不能计算乘法和除法，还有括号运算。
 * @Version 1.0
 */
public class Calculate {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果是数字
            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }
            if (!Character.isDigit(c) || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                }
                //更新符号为当前符号，数字为0
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res+=stack.peek();
            stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Calculate().calculate("1-12+3"));
    }


}
