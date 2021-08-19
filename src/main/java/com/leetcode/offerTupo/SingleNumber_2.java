package com.leetcode.offerTupo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author yamon
 * @Date 2021-08-11 15:11
 * @Description 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,1,0,1,100]
 * 输出：100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/WGki4K
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class SingleNumber_2 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0,right = 2;
        int n = nums.length;
        while (right<n){
            if(nums[left] != nums[right]){
                return nums[left];
            }
            left = left+3;
            right = left+2;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] arr = {30000,500,100,30000,100,30000,100};
        System.out.println(new SingleNumber_2().singleNumber(arr));
    }
}
