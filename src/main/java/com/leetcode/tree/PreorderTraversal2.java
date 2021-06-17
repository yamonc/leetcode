package com.leetcode.tree;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-05-26 8:51
 * @Description 非递归
 * @Version 1.0 前序遍历
 */
public class PreorderTraversal2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root==null){
            return ans;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node = root;
        while (!deque.isEmpty() || node!=null){
            while (node!=null){
                ans.add(node.val);
                deque.push(node);
                node = node.left;
            }
            node = deque.pop();
            node = node.right;
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
        System.out.println(new PreorderTraversal2().preorderTraversal(root));
    }
}
