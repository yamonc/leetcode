package com.test;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-07-01 10:51
 * @Description
 * @Version 1.0
 */
public class Test {
    int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        // 将数组都初始化为 true
        Arrays.fill(isPrim, true);
        for (int i = 2; i < n; i++){
            if (isPrim[i]){
                // i 的倍数不可能是素数了
                for (int j = 2 * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        new Test().countPrimes(12);
    }
}
