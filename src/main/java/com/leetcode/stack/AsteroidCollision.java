package com.leetcode.stack;

import java.util.Stack;

/**
 * @Author yamon
 * @Date 2021-04-19 8:49
 * @Description 给定一个整数数组 asteroids，表示在同一行的行星。
 * <p>
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * <p>
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/asteroid-collision
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            collision: {
                while (!stack.isEmpty() && asteroid < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -asteroid) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -asteroid) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(asteroid);
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = ans.length-1;i>=0;i--){
            ans[i]= stack.pop();
        }
        return ans;
    }
}
