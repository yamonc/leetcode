package com.base.sort.compare.nonExchange;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-08-02 16:58
 * @Description
 * @Version 1.0
 */
public class CountSort {
    public void countSort(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //创建新的数组
        int[] count = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        //排序取值
        int index =0;
        for(int i = 0;i<count.length;i++){
            while (count[i]-->0){
                arr[index++] = i+min;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,3,1,2,8,7,9,4};
        new CountSort().countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
