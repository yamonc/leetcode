package com.leetcode.search.binarySearch;

/**
 * @Author yamon
 * @Date 2021-05-12 9:21
 * @Description
 * @Version 1.0
 */
public class BsearchInternally {
    public int bsearch(int[] a, int n, int val){
        return bsearchInternally(a, 0, n-1,val);
    }
    private int bsearchInternally(int[] a, int low, int high, int value){
        if (low>high){
            return -1;
        }
        int mid = low+((high-low)>>1);
        if (a[mid] == value){
            return mid;
        }else if (a[mid]<value){
            //在右侧查找
            return bsearchInternally(a, mid+1, high, value);
        }else{
            return bsearchInternally(a, low, mid-1,value);
        }
    }

    public static void main(String[] args) {
        int[] arr = {
                8, 11, 19, 23, 27, 33, 45, 55, 67, 98
        };
        System.out.println(new BsearchInternally().bsearch(arr, arr.length, 19));
    }
}
