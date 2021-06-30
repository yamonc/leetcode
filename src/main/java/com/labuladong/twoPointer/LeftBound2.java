package com.labuladong.twoPointer;

/**
 * @Author yamon
 * @Date 2021-06-16 16:10
 * @Description 寻找左侧边界的⼆分搜索 有序数组 nums = [1,2,2,2,3] ， target 为 2，
 * 此算法返回的索 * 引是 2， 没错。 但是如果我想得到 target 的左侧边界， 即索引 1， 或者我
 * 想得到 target 的右侧边界， 即索引 3
 * @Version 1.0 注意跟1的边界对比
 */
public class LeftBound2 {

    public int leftBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //主义边界问题
            if (nums[mid] == target) {
                //收缩右侧边界
                right = mid - 1;
            } else if (nums[mid] < target) {
                //搜索区间变成：[mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                //[left, mid-1]
                right = mid - 1;
            }
        }
        //检查出界问题
        if (left>=nums.length|| nums[left] != target){
            return -1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3};
        System.out.println(new LeftBound2().leftBound(arr, 2));
    }
}
