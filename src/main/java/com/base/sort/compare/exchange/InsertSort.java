package com.base.sort.compare.exchange;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-08-01 16:07
 * @Description
 * @Version 1.0
 */
public class InsertSort {
    /**
     * 简单插入排序
     * @param a 待排序数组
     */
    public void insertSort(int[] a){
        int team;
        for(int i = 1; i<a.length;i++){
            System.out.println(Arrays.toString(a));
            //首先将第1个位置上的数字赋值
            team = a[i];
            for(int j = i-1;j>=0;j--){
                //这个数字和前一个数字进行比较，如果前一个数字大于这个数字，则交换。否则，进行下一个。
                if(a[j]>team){
                    //
                    a[j+1] = a[j];
                    a[j] = team;
                }else{
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,5,3,1,4};
        new InsertSort().insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
