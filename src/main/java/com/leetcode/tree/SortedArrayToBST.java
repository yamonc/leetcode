package com.leetcode.tree;

import java.sql.PreparedStatement;

/**
 * @Author yamon
 * @Date 2021-03-16 9:18
 * @Description
 * @Version 1.0
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums){
        return helper(nums, 0, nums.length-1);
    }


    public TreeNode helper(int[] nums, int left, int right){
        if (left>right){
            return null;
        }
        //总是选择中间位置左边的数字作为树的根
        int mid = (left+right)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid-1);
        root.right = helper(nums, mid+1, right);
        return root;
    }


    public static void main(String[] args) {
        final SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        int[] arr = {-10,-3,0,5,9};
        sortedArrayToBST.sortedArrayToBST(arr);
    }
}
