package com.leetcode.everyday.a202107;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author yamon
 * @Date 2021-04-01 8:38
 * @Description
 * @Version 1.0
 */
public class Clumsy {

    public int clumsy(int N) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(N);
        N--;
        int index = 0;
        while (N>0){
            if (index %4 ==0){
                stack.push(stack.pop() * N);
            }else if (index%4 == 1){
                stack.push(stack.pop()/N);
            }else if (index %4 ==2){
                stack.push(N);
            }else{
                stack.push(-N);
            }
            index++;
            N--;
        }
        int sum=0;
        while (!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Clumsy().clumsy(10));
    }

}
