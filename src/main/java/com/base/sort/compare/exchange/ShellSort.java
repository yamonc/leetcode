package com.base.sort.compare.exchange;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-08-01 16:22
 * @Description
 * @Version 1.0
 */
public class ShellSort {
    public void shellSort(int[] a) {
        int d = a.length;
        //临时变量
        int team = 0;
        for (; d >= 1; d /= 2) {
            //共分为d组,以下就是每个组内的插入排序了。
            for (int i = d; i < a.length; i++) {
                //到哪个元素就看这个元素在哪个组即可
                team = a[i];
                for (int j = i - d; j >= 0; j -= d) {
                    if (a[j] > team) {
                        a[j + d] = a[j];
                        a[j] = team;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {59, 20, 17, 36, 98, 14, 23, 83, 13, 28};
        new ShellSort().shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
