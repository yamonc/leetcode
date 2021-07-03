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
 * @Version 1.0 双指针
 */
public class Trap_3 {
    public int trap(int[] height) {
        int n = height.length;
        if(n==0){
            return 0;
        }
        int ans = 0;
        //数组充当备忘录
        // lMMemo表示的是位置i左侧最高的柱子高度
        int[] lMMemo = new int[n];
        int[] rMMemo = new int[n];
        //初始化数组
        lMMemo[0] = height[0];
        rMMemo[n-1] = height[n-1];
        //从左向右计算左侧最大值
        for(int i = 1;i<n;i++){
            lMMemo[i] = Math.max(height[i], lMMemo[i-1]);
        }
        //从右向左计算右侧最大值
        for(int i = n-2;i>=0;i--){
            rMMemo[i] = Math.max(height[i], rMMemo[i+1]);
        }
        //计算答案
        for(int i = 1;i<n-1;i++){
            ans += Math.min(lMMemo[i], rMMemo[i])-height[i];
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {
                0,1,0,2,1,0,1,3,2,1,2,1
        };
        System.out.println(new Trap_3().trap(arr));
    }
}
