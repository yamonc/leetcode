package com.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-08-04 16:34
 * @Description 入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0 改进之后的版本
 */
public class FindContinuousSequence_2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> ans = new ArrayList<>();
        int l = 1, r = 2, s = 3;
        while (l < r) {
            if (s == target) {
                int[] temp = new int[r - l + 1];
                for(int k = l;k<=r;k++){
                    temp[k-l] = k;
                }
                ans.add(temp);
            }
            if (s < target) {
                r++;
                s += r;
            }else{
                s -= l;
                l++;
            }
        }

        return ans.toArray(new int[0][]);
    }



    public static void main(String[] args) {

        new FindContinuousSequence_2().findContinuousSequence(9);
    }
}
