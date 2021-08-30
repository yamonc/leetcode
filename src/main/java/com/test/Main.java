package com.test;

/**
 * @Author yamon
 * @Date 2021-08-23 15:43
 * @Description 给定一个数组，输入一个数字，查找该数字在数组中的最小和最大index
 * 比如：[1, 2, 3, 3, 3, 3, 3, 5, 7]
 * 输入3，返回2，6
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,4,4,7,11};
        int min = getMinIndex(arr, 111);
        int max = getMaxIndex(arr, 111);
        System.out.println(min);
        System.out.println(max);
        if (max<min){
            System.out.println(-1);
        }

    }
    public static int getMinIndex(int[] arr, int target){
        //二分查找
        int n = arr.length;
        int left = 0, right = n-1;
        while (left <= right){
            int mid = left+(right-left)/2;
            if (arr[mid] == target){
                right = mid -1;
            }else if (arr[mid] > target){
                right=mid-1;
            }else if(arr[mid] < target){
                left=mid+1;
            }
        }
        return left;
    }
    public static int getMaxIndex(int[] arr, int target){
        int n = arr.length;
        int left = 0, right = n -1;
        while (left <= right){
            int mid = left+(right-left)/2;
            if (arr[mid] == target){
                left = mid + 1;
            }else if (arr[mid] > target){
                right=mid-1;
            }else if(arr[mid] < target){
                left=mid+1;
            }
        }
        return right;
    }
}
