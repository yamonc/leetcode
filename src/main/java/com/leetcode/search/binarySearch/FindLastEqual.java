package com.leetcode.search.binarySearch;

/**
 * @Author yamon
 * @Date 2021-05-12 19:28
 * @Description 查找最后一个值等于给定值的元素
 * @Version 1.0
 */
public class FindLastEqual {

    public int bsearch(int[] a, int n, int value){
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low + ((high-low)>>1);
            if (a[mid]>value){
                //在左侧
                high = mid-1;
            }else if (a[mid]<value){
                //在右侧
                low=mid+1;
            }else{
                if (mid==n-1 || a[mid+1]!=value){
                    return mid;
                }else{
                    low=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {
                1, 3, 4, 5, 6, 8, 8, 8, 11, 18
        };
        System.out.println(new FindLastEqual().bsearch(arr, arr.length, 8));
    }
}
