package com.leetcode.offerTupo;

import java.util.Stack;

/**
 * @Author yamon
 * @Date 2021-08-26 15:09
 * @Description 定一个整数数组 asteroids，表示在同一行的行星。
 *
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * 示例 2：
 *
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * 示例 3：
 *
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 * 示例 4：
 *
 * 输入：asteroids = [-2,-1,1,2]
 * 输出：[-2,-1,1,2]
 * 解释：-2 和 -1 向左移动，而 1 和 2 向右移动。 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/asteroid-collision
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            collision:{
                while (!stack.isEmpty() && asteroid<0 && stack.peek()>0){
                    //只有一种情况行星才会发生碰撞：当行星小于0 并且栈顶元素大于0才会发生碰撞。（栈顶表示向右移动，待入栈的元素表示向左移动）
                    if (stack.peek()<-asteroid){
                        //到这里的话，表示行星肯定是负数，添加负号后成正数，直接比较和栈顶比较
                        //如果栈顶元素小于行星的绝对值的话，则弹出，否则的话，默认保留下来
                        //比如栈顶是10，待入栈元素是-5，不会进入这个if语句。
                        //如果栈顶是2，待入栈元素是-5，弹出栈顶元素，然后重新进入while循环，接着跟之前待入栈元素比较
                        stack.pop();
                        continue;
                    }else if (stack.peek() == -asteroid){
                        //当栈顶元素和待入栈行星相同的话，则都爆炸，爆炸的结果就是弹出栈顶元素，待入栈元素也不入栈。
                        stack.pop();
                    }
                    break collision;
                }
                //(1)
                stack.push(asteroid);
            }
        }
        int[] ans = new int[stack.size()];
        for (int t = ans.length-1;t>=0;t--){
            ans[t] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, -5};
        new AsteroidCollision().asteroidCollision(arr);
    }
}
