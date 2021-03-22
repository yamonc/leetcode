package com.leetcode.tree;

/**
 * @Author yamon
 * @Date 2021-03-18 8:44
 * @Description
 * @Version 1.0
 */
public class FindTilt {
    int tilt = 0;
    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }

    public int traverse(TreeNode root){
        if(root==null ){
            return 0;
        }
        int left=traverse(root.left);
        int right=traverse(root.right);
        tilt+=Math.abs(left-right);
        return left+right+root.val;
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(4);
        TreeNode leftLeft = new TreeNode(3);
        TreeNode leftRight = new TreeNode(1);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(5);
        node.left = left;
        node.right=right;
        left.left=leftLeft;
        left.right=leftRight;
        right.left=rightLeft;
        right.right=rightRight;
        System.out.println(new FindTilt().findTilt(node));
    }

}
