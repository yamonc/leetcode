package com.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author yamon
 * @Date 2021-04-20 20:29
 * @Description
 * @Version 1.0
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1) {
        int length = nums1.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = length-1;i>=0;i--){
            while (!stack.isEmpty() && stack.peek() <= nums1[i]){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums1[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,2,4,3};
        new NextGreaterElement().nextGreaterElement(arr);
        int[] arr1 = {1,2,3,4,5};
        int n = arr1.length, index = 0;
        while (true) {
            System.out.println(arr1[index % n]);
            index++;
        }

    }
}
