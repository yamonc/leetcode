package com.labuladong.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author yamon
 * @Date 2021-06-28 16:07
 * @Description 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        //定义栈
        Stack<Integer> stack = new Stack<>();
        //逆着计算
        for (int i = temperatures.length-1; i >= 0; i--) {
            while (!stack.empty() && temperatures[stack.peek()]<=temperatures[i]){
                stack.pop();
            }
            ans[i] = stack.isEmpty()?0:(stack.peek()-i);
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(arr)));
    }
}
