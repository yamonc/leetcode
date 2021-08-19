package com.leetcode.everyday.a202107;

/**
 * @Author yamon
 * @Date 2021-03-02 10:34
 * @Description 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)
 * @Version 1.0
 */
public class NumMatrix {
    int[][] sums;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m>0){
            int n=matrix[0].length;
            sums=new int[m][n+1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i][j+1]=sums[i][j]+matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        for (int i = row1; i <=row2 ; i++) {
            int temp = sums[i][col2+1]-sums[i][col1];
            sum=sum+temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix={
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5},
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
        final int i = numMatrix.sumRegion(2, 1, 4, 3);
        System.out.println(i);

    }
}
