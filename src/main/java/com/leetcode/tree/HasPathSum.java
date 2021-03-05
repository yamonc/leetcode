package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author yamon
 * @Date 2021-01-12 10:03
 * @Description
 * @Version 1.0
 */
public class HasPathSum {
    public static boolean solution(TreeNode root, int sum){
        if (root==null){
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);
        while(!queNode.isEmpty()){
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left==null && now.right==null){
                if (temp==sum){
                    return true;
                }
                continue;
            }
            if (now.left!=null){
                queNode.offer(now.left);
                queVal.offer(now.left.val+temp);
            }
            if (now.right!=null){
                queNode.offer(now.right);
                queVal.offer(now.right.val+temp);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode pLeft = new TreeNode(5);
        TreeNode pRight = new TreeNode(3);
        TreeNode qLeft = new TreeNode((2));
        TreeNode qRight = new TreeNode((3));
        TreeNode p = new TreeNode(1,pLeft,pRight);
        TreeNode q = new TreeNode(1,qLeft,qRight);
    }
}
