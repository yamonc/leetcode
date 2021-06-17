package com.leetcode.hot100;

import java.util.Arrays;

/**
 * @Author yamon
 * @Date 2021-06-07 15:05
 * @Description 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length==0 && nums2.length==1){
            return nums2[0];
        }
        if (nums2.length==0 && nums1.length==1){
            return nums1[0];
        }
        //首先合并数组
        int len = nums1.length+nums2.length;
        int[] temp = Arrays.copyOf(nums1, len);
        for (int i = 0; i < nums2.length; i++) {
            temp[nums1.length+i]=nums2[i];
        }
        //合并完数组之后，排序求中位数
        Arrays.sort(temp);
        if (temp.length%2==0){
            //偶数
            int mid=temp.length/2;
            return (double)(temp[mid]+temp[mid-1])/2;
        }else{
            return temp[temp.length/2];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2};
        int[] arr1 = {3};
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(arr, arr1));
    }
}
