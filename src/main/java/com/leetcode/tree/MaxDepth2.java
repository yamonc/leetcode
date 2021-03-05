package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author yamon
 * @Date 2021-01-29 21:29
 * @Description 记录遍历的层数
 * @Version 1.0
 */
public class MaxDepth2 {
    public static int solution(TreeNode root){
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int ans=0;
        //开始遍历
        while (!queue.isEmpty()){
            int size = queue.size();
            //当队列不为空
            while (size>0){
                //出队列
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
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
