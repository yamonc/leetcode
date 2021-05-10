package com.leetcode.everyday;

/**
 * @Author yamon
 * @Date 2021-03-29 9:10
 * @Description
 * @Version 1.0
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(-3));
    }
}
