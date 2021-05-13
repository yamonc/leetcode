package com.leetcode.search.binarySearch;

import com.leetcode.other.Rotate;

/**
 * @Author yamon
 * @Date 2021-05-13 20:31
 * @Description 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class Rotatesearch {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low +((high-low)>>1);
            if (target==nums[mid]){
                return mid;
            }
            if (nums[0]<=nums[mid]){
                if (nums[0]<=target&&target<nums[mid]){
                    high=mid-1;
                }else {
                    low=mid+1;
                }
            }else {
                if (nums[mid]<target&&target<=nums[n-1]){
                    low=mid+1;
                }else {
                    high=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        new Rotatesearch().search(arr, 0);
    }
}
