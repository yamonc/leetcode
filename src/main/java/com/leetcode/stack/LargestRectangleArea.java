package com.leetcode.stack;

/**
 * @Author yamon
 * @Date 2021-04-23 20:54
 * @Description 暴力解法 柱状图中最大长方形面积
 * @Version 1.0
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        if (length==0){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            int left = i;
            int curHeight = heights[i];
            while (left>0 && heights[left-1] >= curHeight){
                left--;
            }

            int right = i;
            while (right<length-1 && heights[right+1] >= curHeight){
                right++;
            }
            int width = right-left+1;
            res = Math.max(res, width*curHeight);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
