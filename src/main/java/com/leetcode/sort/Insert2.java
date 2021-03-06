package com.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-05-11 19:09
 * @Description 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 示例 3：
 * <p>
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class Insert2 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
       int[][] res = new int[intervals.length+1][2];
       int idx = 0;
       //遍历区间，首先将新区建左边且相离的区间加入结果集
        int i = 0;
        while (i < intervals.length && intervals[i][1]<newInterval[0]){
            res[idx++] = intervals[i++];
        }
        // 接着判断当前区间是否与新区间重叠，重叠的话就进行合并，直到遍历到当前区间在新区间的右边且相离，
        // 将最终合并后的新区间加入结果集
        while (i<intervals.length&&intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res[idx++] = newInterval;
        //最后将新区间右边且相离的区间加入结果集
        while (i<intervals.length){
            res[idx++] = intervals[i++];
        }
        return Arrays.copyOf(res,idx);
    }


    public static void main(String[] args) {
        int[][] arr = {
                {1, 2},
                {3,5},
                {6, 7},
                {8, 10},
                {12, 16},
        };
        int[] temp = {4, 8};
        new Insert2().insert(arr, temp);
    }
}
