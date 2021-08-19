package com.base.sort.compare.exchange;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-08-01 16:36
 * @Description
 * @Version 1.0
 */
public class SelectSort {
    public void selectSort(int[] a){
        for(int i = 0;i<a.length-1;i++){
            //定义最小位置
            int min = i;
            for(int j = i+1;j<a.length;j++){
                //遍历后面的数字，跟第一个数字相比，找出最小的；
                if(a[j]<a[min]){
                    min = j;
                }
            }
            //一遍下来已经找到最小的，然后直接交换
            if(min!=i){
                //与第i个位置交换
                swap(a, i, min);
            }

        }
    }
    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr ={2,5,3,1,4};
        new SelectSort().selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
