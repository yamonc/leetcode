package com.leetcode.everyday;

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
public class CountBitsDemo {

    public int[] countBits(int num) {
        int[] bits=new int[num+1];
        for (int i = 0; i <=num; i++) {
            bits[i]=countOnes(i);
        }
        return bits;
    }

    public int countOnes(int x) {
        int ones=0;
        while (x>0){
            x &=(x-1);
            ones++;
        }
        return ones;
    }


    public int func(int x){
        int countx=0;
        while (x>0){
            countx++;
            x=x&(x-1);
        }
        return countx;
    }

    public static void main(String[] args) {
        final int ints = new CountBitsDemo().func(5);
        System.out.println(ints);

    }

}
