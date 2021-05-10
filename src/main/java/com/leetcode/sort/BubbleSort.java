package com.leetcode.sort;

/**
 * @Author yamon
 * @Date 2021-05-03 10:59
 * @Description
 * @Version 1.0
 */
public class BubbleSort {
    public void bubbleSort(int[] a, int n){
        if (n<=1) {
            return;
        }
        for (int i = 0;i<n;i++){
            //提前退出冒泡排序循环的标志位
            boolean flag = false;
            for (int j = 0;i<n-i-1;++j){
                if (a[j] > a[j+1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true; // 表示有数据交换
                }
            }
            if (!flag) {
                break; // 没有数据交换，提前退出
            }
        }

    }

    public static void main(String[] args) {

        int[] arr = {4,5,6,1,2,3};
        new BubbleSort().bubbleSort(arr,5);
    }
}
