package com.leetcode.other.recall;

/**
 * @Author yamon
 * @Date 2021-06-06 15:46
 * @Description
 * @Version 1.0
 */
public class DistDP {

    public int minDistDp(int[][] matrix, int n){
        int[][] states = new int[n][n];
        int sum = 0;
        for (int j = 0; j < n; j++) {
            //初始化states的第一行数据
            sum+=matrix[0][j];
            states[0][j] = sum;
        }
        sum = 0 ;
        //初始化states的第一列数据
        for (int i = 0; i < n; i++) {
            sum+=matrix[i][0];
            states[i][0] = sum;
        }
        //向下和向右计算值，最后返回最小
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                states[i][j] = matrix[i][j]+Math.min(states[i][j-1],states[i-1][j]);
            }
        }
        return states[n-1][n-1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,9},
                {2,1,3,4},
                {5,2,6,7},
                {6,8,4,3},
        };
        new DistDP().minDistDp(matrix,matrix.length);
    }
}
