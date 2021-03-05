package com.leetcode.practice;

/**
 * @Author yamon
 * @Date 2021-02-24 11:07
 * @Description
 * @Version 1.0
 */
public class TreeNode {
    int data;
    TreeNode leftNode;
    TreeNode rightNode;

    public TreeNode(){

    }
    public TreeNode(int d){
        data = d;
    }
    public TreeNode(TreeNode left,TreeNode right,int d){
        leftNode=left;
        rightNode=right;
        data = d;
    }

}
