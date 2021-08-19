package com.leetcode.everyday.a202107;

/**
 * @Author yamon
 * @Date 2021-03-03 11:23
 * @Description 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * @Version 1.0
 */
public class CountBits {

    public int[] countBits(int num) {
        int[] temp=new int[num+1];
        for (int i = 0; i <=num; i++) {
            //转为二进制数
            final String binaryString = Integer.toBinaryString(i);
            final char[] chars = binaryString.toCharArray();
            int count=0;
            for (char aChar : chars) {
                if (aChar=='1'){
                    count++;
                }
            }
            temp[i]=count;
        }
        return temp;
    }

    public static void main(String[] args) {
        final int[] ints = new CountBits().countBits(2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
