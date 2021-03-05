package com.leetcode.tree;

/**
 * @Author yamon
 * @Date 2021-01-29 21:40
 * @Description
 * @Version 1.0
 */
public class MinDepth {
    public static int minDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.left==null && root.right==null){
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null){
            min_depth=Math.min(minDepth(root.left),min_depth);
        }
        if (root.right != null){
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth+1;
    }
}
