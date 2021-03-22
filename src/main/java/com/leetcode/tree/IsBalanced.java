package com.leetcode.tree;

import java.sql.Struct;

/**
 * @Author yamon
 * @Date 2021-03-08 10:38
 * @Description
 * @Version 1.0
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }else{
            return Math.abs(height(root.left)-height(root.right))<=1&& isBalanced(root.left) && isBalanced(root.right) && isBalanced(root.right);
        }
    }

    private int height(TreeNode root) {
        if (root==null){
            return 0;
        }else {
            return Math.max(height(root.left),height(root.right))+1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        root.left=left;
        root.right= right;
        right.left=rightLeft;
        right.right=rightRight;
        new IsBalanced().isBalanced(root);
    }
}
