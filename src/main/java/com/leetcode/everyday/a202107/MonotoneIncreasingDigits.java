package com.leetcode.everyday.a202107;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2020-12-15 9:09
 * @Description 从后往前遍历，如果前面的值大于后面的值就把当前位数减一然后把后面的值变成9，以此类推
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * @Version 1.0
 */
public class MonotoneIncreasingDigits {
    public static int solution(int N){
        if (N<10){
            return N;
        }
        final String[] strings = Integer.toString(N).split("");
        for (int i = strings.length-2; i > -1; i--) {

            if (Integer.parseInt(strings[i])>Integer.parseInt(strings[i+1])){
                int bigger = Integer.parseInt(strings[i])-1;
                strings[i]=String.valueOf(bigger);
                for (int j = i+1;j<strings.length;j++){
                    strings[j]="9";
                }

            }

        }
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(solution(521));
    }
}
