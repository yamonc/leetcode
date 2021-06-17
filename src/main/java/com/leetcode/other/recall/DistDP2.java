package com.leetcode.other.recall;

/**
 * @Author yamon
 * @Date 2021-06-06 15:46
 * @Description
 * @Version 1.0 动态规划
 */
public class DistDP2 {
    public int n = 4;
    private int[][] mem = new int[4][4];
    private int[][] matrix = {
            {1,3,5,9},
            {2,1,3,4},
            {5,2,6,7},
            {6,8,4,3},
    };
    public int minDistDp(int i, int j){
        if (i==0 && j==0){
            return mem[i][j];
        }
        if (mem[i][j]>0){
            return mem[i][j];
        }
        int minLeft = Integer.MAX_VALUE;
        if (j-1>=0){
            minLeft = minDistDp(i, j-1);
        }
        int minUp = Integer.MAX_VALUE;
        if (i-1>=0){
            minUp = minDistDp(i-1, j);
        }
        int currMinDist = matrix[i][j] + Math.min(minLeft, minUp);
        mem[i][j] = currMinDist;
        return currMinDist;
    }

    public static void main(String[] args) {

        System.out.println(new DistDP2().minDistDp(3, 3));
    }
}
