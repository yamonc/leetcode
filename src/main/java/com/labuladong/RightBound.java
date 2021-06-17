package com.labuladong;

/**
 * @Author yamon
 * @Date 2021-06-16 16:50
 * @Description 寻找右侧边界的⼆分查找
 *寻找右侧边界的⼆分搜索 有序数组 nums = [1,2,2,2,3] ， target 为 2，
 *  * 此算法返回的索 * 引是 2， 没错。 但是如果我想得到 target 的左侧边界， 即索引 1， 或者我
 *  * 想得到 target 的右侧边界， 即索引 3
 * @Version 1.0
 */
public class RightBound {

    public int right_bound(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while(left<right){
            int mid = left+(right-left)/2;
            if (nums[mid] == target){
                //给右移动，不考虑mid位置
                left = mid+1;
            }else if(nums[mid] > target){
                //当大于target的时候,给左移
                right = mid-1;
            }else if(nums[mid] < target){
                left = mid+1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] arr = {
                1,2,4,4,4,5
        };
        System.out.println(new RightBound().right_bound(arr, 4));
    }
}
