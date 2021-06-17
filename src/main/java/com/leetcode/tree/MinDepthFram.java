package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author yamon
 * @Date 2021-01-29 21:40
 * @Description 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *
 * @Version 2.0 框架解题
 */
public class MinDepthFram {
    public static int minDepth(TreeNode root){
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while (!q.isEmpty()){
            int ql =q.size();
            for (int i = 0; i < ql; i++) {
                TreeNode cur = q.poll();
                if (cur.left==null && cur.right==null){
                    return depth;
                }
                if (cur.left!=null){
                    q.offer(cur.left);
                }
                if (cur.right!=null){
                    q.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
