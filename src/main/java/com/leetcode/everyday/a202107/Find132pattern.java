package com.leetcode.everyday.a202107;

import java.util.Stack;

/**
 * @Author yamon
 * @Date 2021-03-24 9:30
 * @Description 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 *
 * 注意：n 的值小于15000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/132-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class Find132pattern {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i]=Math.min(min[i-1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1; i >=0; i--) {
            if (nums[i]>min[i]){
                //如果栈中的数字比min还小或者相同，说明不可能是ak
                while (!stack.isEmpty()&&stack.peek() <= min[i]){
                    stack.pop();
                }
                // 检查一下栈顶元素是不是满足 ai<stack.peek()<aj，如果满足就说明找到了
                if (!stack.isEmpty() && stack.peek()<nums[i]){
                    return true;
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {-1, 3, 2, 0};
        new Find132pattern().find132pattern(a);
    }



}
