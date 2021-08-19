package com.leetcode.offer;

/**
 * @Author yamon
 * @Date 2021-08-03 16:19
 * @Description
 * @Version 1.0
 */
public class FindNthDigit {

    public int findNthDigit(int n) {
        int digit = 1;
        int start = 1;
        int count = 9;

        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = start + digit * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

    public static void main(String[] args) {
        System.out.println(new FindNthDigit().findNthDigit(15));
    }

}
