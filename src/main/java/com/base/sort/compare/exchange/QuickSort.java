package com.base.sort.compare.exchange;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-08-01 15:30
 * @Description
 * @Version 1.0
 */
public class QuickSort {
    /**
     * 快速排序算法
     *
     * @param a     待排序数组
     * @param left  左边界
     * @param right 右边界
     */
    public void quickSort(int[] a, int left, int right) {
        //重新赋值两个变量，这两个变量根据数组变化而变化，但是left和right不能变，分治的时候需要
        int low = left;
        int high = right;
        //分治递归停止条件
        if (low > high) {
            return;
        }
        //首先取哨兵也就是第一个位置上的数字作为待比较的数字
        int k = a[low];
        while (low < high) {
            while (low < high && a[high] >= k) {
                high--;
            }
            //否则的话就需要交换两个数字
            a[low] = a[high];
            while (low < high && a[low] <= k) {
                low++;
            }
            //否则的话，需要交换
            a[high] = a[low];
        }
        //分治前的最后一步也需要
        a[low] = k;
        //开始分治
        quickSort(a, left, low - 1);
        quickSort(a, low + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 9, 8, 2, 6, 4, 7};
        new QuickSort().quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
