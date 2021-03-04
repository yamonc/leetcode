package com.leetcode.tree;

/**
 * @Author yamon
 * @Date 2020-12-22 9:51
 * @Description 对称二叉树01
 * @Version 1.0
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root){
        if (root==null) {
            return true;
        }
        return  dfs(root.left,root.right);

    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left==null && right==null){
            return true;
        }
        if (left==null || right==null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }
}
