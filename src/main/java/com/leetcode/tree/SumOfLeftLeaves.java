package com.leetcode.tree;

import java.util.ArrayList;

/**
 * @Author yamon
 * @Date 2021-03-17 8:45
 * @Description 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    private int dfs(TreeNode root) {
        int sum = 0;
        if (root.left != null) {
            sum += isLeafNode(root.left) ? root.left.val : dfs(root.left);
        }
        if (root.right!=null && !isLeafNode(root.right)){
            sum += dfs(root.right);
        }
        return sum;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        node.left = left;
        node.right=right;
        right.left=rightLeft;
        right.right=rightRight;
        new SumOfLeftLeaves().sumOfLeftLeaves(node);
    }
}
