package com.leetcode.tree;

import sun.reflect.generics.tree.Tree;

/**
 * @Author yamon
 * @Date 2021-01-29 21:29
 * @Description
 * @Version 1.0
 */
public class MaxDepth {
    public static int solution(TreeNode root){
        if (root == null ){
            return 0;
        }else {
            int leftHeight = solution(root.left);
            int rightHeight = solution(root.right);
            return Math.max(leftHeight, rightHeight)+1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left=new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left=left;
        root.right=right;
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        right.left=rightLeft;
        right.right=rightRight;
        final int solution = solution(root);
        System.out.println(solution);

    }
}
