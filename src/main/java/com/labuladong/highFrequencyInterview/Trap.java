package com.labuladong.highFrequencyInterview;

/**
 * @Author yamon
 * @Date 2021-07-02 8:55
 * @Description 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0 暴力法
 */
public class Trap {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        for(int i = 1;i<n-1;i++){
            int lMax = 0;
            int rMax = 0;
            //找出最右边的最高的柱子
            for(int j = i;j<n;j++){
                rMax = Math.max(rMax, height[j]);
            }
            //找出左侧最高的柱子
            for(int j =i;j>=0;j--){
                lMax = Math.max(lMax, height[j]);
            }
            //如果自己是最高的话,lMax,rMax和height[i]相等
            ans += Math.min(lMax, rMax)-height[i];
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {
                0,1,0,2,1,0,1,3,2,1,2,1
        };
        System.out.println(new Trap().trap(arr));
    }
}
