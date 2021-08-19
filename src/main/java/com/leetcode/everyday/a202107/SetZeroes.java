package com.leetcode.everyday.a202107;

import java.util.*;

/**
 * @Author yamon
 * @Date 2021-03-21 8:50
 * @Description 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 使用标记数组
 * @Version 1.0
 */
public class SetZeroes {
    private final Set<Integer> positions = new HashSet<>();

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    //设置行为0
                    row[i]=col[j]=true;
                }
            }
        }
        System.out.println(Arrays.toString(row));
        System.out.println(Arrays.toString(col));
        //遍历数组设置行和列为0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(matrix));
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] matrix1 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        new SetZeroes().setZeroes(matrix1);
    }
}
