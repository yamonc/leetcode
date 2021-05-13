package com.leetcode.search.binarySearch;

/**
 * @Author yamon
 * @Date 2021-05-12 19:28
 * @Description 查找第一个值等于给定值的元素
 * @Version 1.0
 */
public class FindFirstLessEqual {

    public int bsearch(int[] a, int n, int value){
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low + ((high-low)>>1);
            if (a[mid]<=value){
                if (mid==0||a[mid+1] >value){
                    return mid;
                }else{
                    low=mid+1;
                }
            }else {
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {
                3, 4, 6, 7, 10
        };
        System.out.println(new FindFirstLessEqual().bsearch(arr, arr.length, 8));
    }
}
