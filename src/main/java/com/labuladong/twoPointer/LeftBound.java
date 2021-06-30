package com.labuladong.twoPointer;

/**
 * @Author yamon
 * @Date 2021-06-16 16:10
 * @Description 寻找左侧边界的⼆分搜索 有序数组 nums = [1,2,2,2,3] ， target 为 2，
 * 此算法返回的索 * 引是 2， 没错。 但是如果我想得到 target 的左侧边界， 即索引 1， 或者我
 * 想得到 target 的右侧边界， 即索引 3
 * @Version 1.0
 */
public class LeftBound {

    public int leftBound(int[] nums, int target){
        if (nums.length==0){
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while(left<right){
            int mid = left+(right-left)/2;
            if (nums[mid] == target){
                right = mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3};
        System.out.println(new LeftBound().leftBound(arr, 2));
    }
}
