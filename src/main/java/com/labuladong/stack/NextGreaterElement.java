package com.labuladong.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author yamon
 * @Date 2021-06-28 15:51
 * @Description 单个数组中的下一个更大的数儿。
 * @Version 1.0
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums) {
        int[] ans=new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length-1; i >= 0; i--) {
            while (!stack.empty() && stack.peek()<=nums[i]){
                stack.pop();
            }
            ans[i] = stack.empty()?-1: stack.peek();
            stack.push(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,2,4,3};
        System.out.println(Arrays.toString(new NextGreaterElement().nextGreaterElement(arr)));
    }
}
