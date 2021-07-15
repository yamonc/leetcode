package com.base.sort;

import java.nio.file.ClosedWatchServiceException;

/**
 * @Author yamon
 * @Date 2021-07-14 17:50
 * @Description 代码有问题
 *
 * @Version 1.0
 */
public class QuickSort {
    public void quickSort(int[] arr, int l, int r){
        int i,j,temp,t;
        if(l>r){
            return;
        }
        i=l;
        j=r;
        //temp就是基准位置
        temp = arr[l];
        while (i<j){
            //先看右边，依次给左递减
            while (temp<=arr[j] && i<j){
                j--;
            }
            //左边，依次递增
            while (temp>=arr[i] && i<j){
                i++;
            }
            //如果满足条件，交换位置
            if(i<j){
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准与 i和j相等的位置数字交换
        arr[l] = arr[i];
        arr[i] = temp;
        //递归调用左半个数组
        quickSort(arr, l, j-1);
        //递归调用右半个数组
        quickSort(arr, j+1, r);
    }
    public static void main(String[] args){
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        new QuickSort().quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
