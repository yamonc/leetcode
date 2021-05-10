package com.leetcode.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Author yamon
 * @Date 2021-04-07 8:34
 * @Description
 * @Version 1.0
 */
public class Tree2str {
    public String tree2str(TreeNode t) {
        if (t == null)
            return "";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(t);
        Set<TreeNode> visited = new HashSet<>();
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            t = stack.peek();
            if (visited.contains(t)) {
                stack.pop();
                s.append(")");
            } else {
                visited.add(t);
                s.append("(" + t.val);
                if (t.left == null && t.right != null)
                    s.append("()");
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftLeft = new TreeNode(4);
        TreeNode rightRight = new TreeNode(6);
        root.left = left;
        root.right = right;
        left.left = leftLeft;
        right.right = rightRight;
        System.out.println(new Tree2str().tree2str(root));
    }
}
