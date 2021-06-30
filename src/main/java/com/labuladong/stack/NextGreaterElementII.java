package com.labuladong.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author yamon
 * @Date 2021-06-28 15:51
 * @Description 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class NextGreaterElementII {
    public int[] nextGreaterElement(int[] nums) {
        int[] ans=new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2*nums.length-1; i >= 0; i--) {
            while (!stack.empty() && stack.peek()<=nums[i%nums.length]){
                stack.pop();
            }
            ans[i%nums.length] = stack.empty()?-1: stack.peek();
            stack.push(nums[i%nums.length]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,2,4,3};
        System.out.println(Arrays.toString(new NextGreaterElementII().nextGreaterElement(arr)));
    }
}
