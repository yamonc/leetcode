package com.labuladong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-06-30 15:35
 * @Description 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][1];
        }
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0],o2[0]));
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for(int i = 0;i<intervals.length;i++){
            int[] cur =  intervals[i];
            //ans中最后一个元素的引用
            int[] last = ans.get(ans.size()-1);
            if(cur[0]<=last[1]){
                //找到最大的end
                last[1] = Math.max(last[1],cur[1]);
            }else{
                //处理下一个待合并的区间
                ans.add(cur);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args){
        int[][] arr = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        System.out.println(Arrays.deepToString(new Merge().merge(arr)));
    }
}
