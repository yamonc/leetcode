package com.leetcode.tree;

import static java.lang.Math.max;

/**
 * @Author yamon
 * @Date 2021-04-09 8:42
 * @Description
 * @Version 1.0
 */
public class MaxPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    public int maxGain(TreeNode node){
        if (node==null){
            return 0;
        }

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int priceNewPath = node.val+leftGain+rightGain;
        maxSum = Math.max(maxSum, priceNewPath);
        return node.val+Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = rightLeft;
        right.right = rightRight;
        System.out.println(new MaxPathSum().maxPathSum(root));
    }
}
