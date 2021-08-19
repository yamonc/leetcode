package com.leetcode.everyday.a202108;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-08-03 14:39
 * @Description 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class FindUnsortedSubarray {
    /**
     * 双指针：
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        //先特判
        if(nums.length==0|| nums.length==1){
            return 0;
        }
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int i = 0, j=n-1;
        while(i<=j && nums[i] == arr[i]){
            i++;
        }
        while (i<=j && nums[j] == arr[j]){
            j--;
        }
        return j-i+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        new FindUnsortedSubarray().findUnsortedSubarray(arr);
    }
}
