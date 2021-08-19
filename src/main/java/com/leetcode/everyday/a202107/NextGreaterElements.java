package com.leetcode.everyday.a202107;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author yamon
 * @Date 2021-03-06 9:15
 * @Description 503 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * @Version 1.0
 */
public class NextGreaterElements {


    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty()&&nums[stack.peek()] < nums[i%n]){
                res[stack.pop()]=nums[i%n];
            }
            stack.push(i%n);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] demo = {
                1,8,-1,-100,-1,-222,1111111,-111111
        };
        final int[] ints = new NextGreaterElements().nextGreaterElements(demo);
        System.out.println(Arrays.toString(ints));
    }


}
