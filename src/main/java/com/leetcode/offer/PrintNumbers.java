package com.leetcode.offer;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-07-27 9:22
 * @Description 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class PrintNumbers {
    public int[] printNumbers(int n) {
        int end = (int) (Math.pow(10, n)-1);
        int[] ans = new int[end];
        for(int i = 1;i<=ans.length;i++){
            ans[i-1]=i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PrintNumbers().printNumbers(3)));
    }
}
