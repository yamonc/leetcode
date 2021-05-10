package com.leetcode.everyday;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author yamon
 * @Date 2021-03-30 8:33
 * @Description
 * @Version 1.0
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        Set<Integer> set = new HashSet<>();

        //将二维矩阵转为一维矩阵
        int m = matrix.length;
        int n = matrix[0].length;
        int[] temp=new int[m*n];
        int index = 0;
        for (int[] array : matrix) {
            for (int element : array) {
                temp[index++] = element;
            }
        }
        //二分查找
        return binarySearch(temp,target);
    }

    public boolean binarySearch(int[] matrix, int target){
        int low = 0;
        int height = matrix.length-1;
        while (low <= height){
            int mid = (height-low)/2+low;
            if (matrix[mid] == target){
                return true;
            }else if (matrix[mid]>target){
                height = mid-1;
            }else {
                low = mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(new SearchMatrix().searchMatrix(matrix, 34));
    }
}
