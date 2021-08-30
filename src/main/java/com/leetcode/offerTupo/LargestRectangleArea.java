package com.leetcode.offerTupo;

/**
 * @Author yamon
 * @Date 2021-08-26 16:08
 * @Description 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * 示例 2：
 *
 *
 *
 * 输入： heights = [2,4]
 * 输出： 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len==0){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            //找到左边最后一个大于等于height[i]的下标
            int left = i;
            int curHeight = heights[i];
            while (left>0 && heights[left-1]>=curHeight){
                left--;
            }

            //找到右边最后一个大于等于height[i]的下标
            int right = i;
            while (right<len-1 && heights[right+1]>= curHeight){
                right++;
            }
            int width = right-left+1;
            res = Math.max(res, width*curHeight);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        System.out.println(new LargestRectangleArea().largestRectangleArea(arr));
    }
}
