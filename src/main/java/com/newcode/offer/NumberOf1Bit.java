package com.newcode.offer;

import java.util.HashMap;

/**
 * @Author yamon
 * @Date 2021-06-12 16:34
 * @Description
 * @Version 1.0
 */
public class NumberOf1Bit {

    public int NumberOf1(int n) {
        if (n==0){
            return 0;
        }
        int res = 0;
        while (n!=0){
            //计算1 的个数
            n = n&(n-1);
            res ++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1Bit().NumberOf1(3));
    }
}
