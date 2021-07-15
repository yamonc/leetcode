package com.leetcode.plan.easy21;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-07-04 13:58
 * @Description 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0 双指针，找出负数的位置，然后平方归并排序
 */
public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int negative = -1;
        //首先找出来第一个负数的位置
        for(int i = 0;i<n;i++){
            if(nums[i]<0){
                negative = i;
            }else{
                break;
            }
        }
        //先直接平方
        int[] ans = new int[n];
        int index = 0,i=negative,j=negative+1;
        while (i>=0 || j<n){
            if(i<0){
                ans[index]=nums[j]*nums[j];
                j++;
            }else if(j==n){
                ans[index] = nums[i]*nums[i];
                i--;
            }else if(nums[i]*nums[i] < nums[j]*nums[j]){
                ans[index] = nums[i] * nums[i];
                i--;
            }else{
                ans[index] = nums[j] * nums[j];
                j++;
            }
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {
                -4,-1,0,3,10
        };
        new SortedSquares().sortedSquares(arr);
    }
}
