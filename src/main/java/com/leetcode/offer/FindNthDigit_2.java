package com.leetcode.offer;

/**
 * @Author yamon
 * @Date 2021-08-03 16:19
 * @Description
 * @Version 1.0
 */
public class FindNthDigit_2 {

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

    public static void main(String[] args) {
        System.out.println(new FindNthDigit_2().findNthDigit(15));
    }

}
