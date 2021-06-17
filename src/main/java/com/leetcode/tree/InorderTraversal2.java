package com.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-05-25 8:49
 * @Description 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * @Version 2
 */
public class InorderTraversal2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (root!=null || !deque.isEmpty()){
            while (root!=null){
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
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
        System.out.println(new InorderTraversal2().inorderTraversal(root));
    }
}
