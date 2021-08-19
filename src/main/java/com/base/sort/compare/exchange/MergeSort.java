package com.base.sort.compare.exchange;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-08-02 15:59
 * @Description 归并排序
 * @Version 1.0
 */
public class MergeSort {
    public void mergeSort(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (left<right){
            //复杂度o(logn)
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            //o(n)
            merge(arr, left, mid, right);
        }

    }
    public void merge(int[] arr, int l, int mid, int r){
        int lindex = l, rindex = mid+1;
        int team[] = new int[r-l+1];
        int teamIndex = 0;
        while (lindex <= mid && rindex<=r){
            //先左右比较
            if(arr[lindex]<=arr[rindex]){
                team[teamIndex++] = arr[lindex++];
            }else {
                team[teamIndex++] = arr[rindex++];
            }
        }
        while (lindex<=mid){
            //当一个越界后剩余按序号添加即可
            team[teamIndex++] = arr[lindex++];
        }
        while (rindex<=r){
            team[teamIndex++] = arr[rindex++];
        }

        for(int i = 0;i<teamIndex;i++){
            arr[l+i] = team[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,2,6,3,8,1,7,4,10,60};
        new MergeSort().mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
