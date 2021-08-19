package com.leetcode.everyday.a202108;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-08-02 18:40
 * @Description 朴素的做法：对矩阵遍历，统计每一行的军人数量，并以二元组的形式保存key和value。最后进行排序
 * @Version 1.0
 */
public class KWeakestRows_2 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] all = new int[m][2];
        for(int i =0;i<m;i++){
            int cur = 0;
            for(int j = 0;j<n;j++){
                cur += mat[i][j];
            }
            all[i] = new int[]{cur, i};
        }
        Arrays.sort(all, (a, b)->{
            if(a[0] != b[0]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        int[] ans = new int[k];
        for(int i = 0;i<k;i++){
            ans[i] = all[i][1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,0,0,0},
                {1,1,1,1},
                {1,0,0,0},
                {1,0,0,0}
        };
        new KWeakestRows_2().kWeakestRows(arr, 2);
    }
}
