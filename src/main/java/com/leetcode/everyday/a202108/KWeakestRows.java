package com.leetcode.everyday.a202108;

import java.util.*;

/**
 * @Author yamon
 * @Date 2021-08-02 18:05
 * @Description 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 *
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 *
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 *
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：mat =
 * [[1,1,0,0,0],
 *  [1,1,1,1,0],
 *  [1,0,0,0,0],
 *  [1,1,0,0,0],
 *  [1,1,1,1,1]],
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 2
 * 行 4 -> 5
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 * 示例 2：
 *
 * 输入：mat =
 * [[1,0,0,0],
 *  [1,1,1,1],
 *  [1,0,0,0],
 *  [1,0,0,0]],
 * k = 2
 * 输出：[0,2]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 1
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 1
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class KWeakestRows {

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        //TreeMap
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0;i<m;i++){
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(mat[i][j]!=0){
                    count++;
                }
            }
            map.put(i, count);
        }
        //根据value值逆序
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(entries);
        Collections.sort(list, (o1, o2) -> {
            if(o1.getValue().compareTo(o2.getValue())!=0){
                return o1.getValue().compareTo(o2.getValue());
            }else if(o1.getKey().compareTo(o2.getKey())!=0){
                return o1.getKey().compareTo(o2.getKey());
            }else{
                return 0;
            }
        });

        int[] ans = new int[k];
        int idx = 0;
        while (k>0){
//            int a = list.get(idx).getKey();
//            System.out.println(list.get(idx).getKey());
            ans[idx++] = list.get(idx).getKey();
            k--;
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
        System.out.println(Arrays.toString(new KWeakestRows().kWeakestRows(arr, 2)));
    }
}
