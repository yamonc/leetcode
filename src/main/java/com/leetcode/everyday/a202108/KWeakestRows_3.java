package com.leetcode.everyday.a202108;

import java.util.PriorityQueue;

/**
 * @Author yamon
 * @Date 2021-08-02 18:40
 * @Description 朴素的做法：对矩阵遍历，统计每一行的军人数量，并以二元组的形式保存key和value。最后进行排序
 * @Version 1.0
 */
public class KWeakestRows_3 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->{
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (mat[i][mid] >= 1) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int cur = mat[i][r] >= 1 ? r + 1 : r;
            if (q.size() == k && q.peek()[0] > cur) {
                q.poll();
            }
            if (q.size() < k) {
                q.add(new int[]{cur, i});
            }
        }
        int[] ans = new int[k];
        int idx = k - 1;
        while (!q.isEmpty()) {
            ans[idx--] = q.poll()[1];
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
        new KWeakestRows_3().kWeakestRows(arr, 2);
    }
}
