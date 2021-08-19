package com.base.sort.compare.exchange;

/**
 * @Author yamon
 * @Date 2021-08-01 15:22
 * @Description
 * @Version 1.0
 */
public class BubblingSort {
    public void bubblingSort(int[] a){
        for(int i = a.length-1;i>=0;i--){
            for(int j = 0;j<i;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] =temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr ={2,5,1,4,3};
        new BubblingSort().bubblingSort(arr);
    }
}
