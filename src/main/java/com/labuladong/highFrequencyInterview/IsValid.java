package com.labuladong.highFrequencyInterview;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author yamon
 * @Date 2021-07-02 15:29
 * @Description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> left = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                left.push(c);
            }else{
                //字符c是右括号
                if(!left.empty() && leftOf(c) == left.peek()){
                    left.pop();
                }else{
                    //和最近的左括号不匹配
                    return false;
                }
            }
        }
        return left.empty();
    }
    public char leftOf(char c){
        if(c=='}'){
            return '{';
        }
        if (c == ')') {
            return '(';
        }
        return '[';
    }

    public static void main(String[] args){
        new IsValid().isValid("()[]{}");
    }
}
