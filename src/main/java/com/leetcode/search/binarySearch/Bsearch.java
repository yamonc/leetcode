package com.leetcode.search.binarySearch;

/**
 * @Author yamon
 * @Date 2021-05-12 9:17
 * @Description
 * @Version 1.0
 */
public class Bsearch {
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {
                8, 11, 19, 23, 27, 33, 45, 55, 67, 98
        };
        System.out.println(new Bsearch().bsearch(arr, arr.length, 19));
    }
}
