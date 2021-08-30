package com.leetcode.offerTupo;

import com.labuladong.preDefine.TreeNode;

import java.util.*;

/**
 * @Author yamon
 * @Date 2021-08-27 15:30
 * @Description
 * @Version 1.0
 */
public class CBTInserter {
    List<TreeNode> list = new ArrayList<>();

    public CBTInserter(TreeNode root) {
        if (root == null) {
            return;
        }
        //bfs广度优先遍历
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            list.add(treeNode);
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        list.add(node);
        //得到父节点
        int parent = list.size() / 2 - 1;
        //拼接节点，先判断是左节点还是右节点
        if (list.size() % 2 == 0) {
            list.get(parent).left = node;
        } else {
            list.get(parent).right = node;
        }
        //返回节点值
        return list.get(parent).val;
    }

    public TreeNode get_root() {
        return list.isEmpty() ? null : list.get(0);
    }
}
