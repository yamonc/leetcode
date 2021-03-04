package com.leetcode.everyday;

/**
 * @Author yamon
 * @Date 2020-12-19 9:55
 * @Description
 * @Version 1.0
 */
public class Rotate {
    public static void rotate(int[][] matrix){
        int n = matrix.length;
        //借助一个新的数组
        int[][] matrixNew = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixNew[j][n-i-1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j]= matrixNew[i][j];
            }
        }

    }
}
