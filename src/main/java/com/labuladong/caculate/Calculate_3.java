package com.labuladong.caculate;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author yamon
 * @Date 2021-06-23 15:28
 * @Description 只能计算加减乘除法，考虑计算括号运算。 没有做出来
 * @Version 3.0
 */
public class Calculate_3 {
    public int calculate(String s) {

        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果是数字
            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }
            if (c == '('){
                num = calculate(s);
            }
            if ((!Character.isDigit(c) && c!=' ')|| i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        int mPre = stack.peek();
                        stack.pop();
                        stack.push(mPre * num);
                        break;
                    case '/':
                        int dPre = stack.peek();
                        stack.pop();
                        stack.push(dPre / num);
                        break;
                }
                //更新符号为当前符号，数字为0
                sign = c;
                num = 0;
                if (c == ')'){
                    break;
                }
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.peek();
            stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Calculate_3().calculate("3*(4-5/2)-6"));
    }


}
