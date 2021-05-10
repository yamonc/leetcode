package com.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-04-11 9:51
 * @Description
 * @Version 1.0
 */
public class addToArrayForm2 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length;
        LinkedList<Integer> res = new LinkedList<>();
        int i = n - 1, sum = 0, carry = 0;
        while (i >= 0 || k != 0) {
            int x = i >= 0 ? num[i] : 0;
            int y = k != 0 ? k % 10 : 0;

            sum = x + y + carry;
            carry = sum / 10;
            k = k / 10;

            i--;
            res.addFirst(sum % 10);
        }
        if (carry != 0) {
            res.add(0, carry);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {2, 1, 5};
        int k = 806;
        System.out.println(new addToArrayForm2().addToArrayForm(num, k));
    }
}
