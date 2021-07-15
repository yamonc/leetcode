package com.leetcode.offer.tree;

import com.labuladong.preDefine.TreeNode;

/**
 * @Author yamon
 * @Date 2021-07-10 16:18
 * @Description
 * @Version 1.0
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {

        return recur(root);
    }

    public int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = recur(root.left);
        int r = recur(root.right);
        return Math.max(l, r)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l = new TreeNode(9);
        TreeNode r = new TreeNode(20);
        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);
        root.left = l;
        root.right = r;
        r.left=rl;
        r.right = rr;
        System.out.println(new MaxDepth().maxDepth(root));
    }
}
