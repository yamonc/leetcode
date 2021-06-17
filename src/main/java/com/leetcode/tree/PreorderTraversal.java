package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-05-26 8:51
 * @Description
 * @Version 1.0
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preSolution(root, ans);
        return ans;
    }
    public void preSolution(TreeNode root, List<Integer> ans){
        if (root==null){
            return;
        }
        ans.add(root.val);
        preSolution(root.left, ans);
        preSolution(root.right, ans);
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
        System.out.println(new PreorderTraversal().preorderTraversal(root));
    }
}
