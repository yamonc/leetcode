package com.leetcode.offer;

import java.util.*;

/**
 * @Author yamon
 * @Date 2021-07-20 14:45
 * @Description 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0){
            return new int[0];
        }
        int l = 0;
        int length = nums.length;
        int[] ans = new int[length-k+1];
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<ans.length;i++){
            for(int j = l;j<l+k&&j<nums.length;j++){
                max =  Math.max(max, nums[j]);
            }
            ans[i] = max;
            max = Integer.MIN_VALUE;
            l++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(arr, 3)));
    }
}
