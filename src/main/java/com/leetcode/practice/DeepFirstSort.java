package com.leetcode.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author yamon
 * @Date 2021-02-24 11:09
 * @Description 深度优先遍历和广度优先遍历
 * @Version 1.0
 */
public class DeepFirstSort {


    public void BroadFirstSearch(TreeNode nodeHead){
        if (nodeHead==null){
            return;
        }
        Queue<TreeNode> myQueue=new LinkedList<>();
        myQueue.add(nodeHead);
        while (!myQueue.isEmpty()){
            //出队列
            TreeNode node = myQueue.poll();
            System.out.print(node.data+" ");
            if (node.leftNode!=null){
                //左节点不为空
                myQueue.add(node.leftNode);
            }
            if (node.rightNode!=null){
                myQueue.add(node.rightNode);
            }
        }
    }









    public void depthFirstSearch(TreeNode nodeHead){
        if (nodeHead==null){
            return;
        }
        //使用栈
        Stack<TreeNode> myStack = new Stack<>();
        //添加头结点
        myStack.add(nodeHead);
        while(!myStack.isEmpty()){
            //当栈不为空的时候，一直遍历
            //首先弹出栈顶元素
            TreeNode node = myStack.pop();
            //子树入栈
            System.out.print(node.data+" ");
            if (node.rightNode!=null){
                myStack.push(node.rightNode);
            }
            if (node.leftNode!=null){
                myStack.push(node.leftNode);
            }

        }

    }

    public static void main(String[] args) {
        TreeNode head=new TreeNode(1);
        TreeNode second=new TreeNode(2);
        TreeNode three=new TreeNode(3);
        TreeNode four=new TreeNode(4);
        TreeNode five=new TreeNode(5);
        TreeNode six=new TreeNode(6);
        TreeNode seven=new TreeNode(7);
        head.rightNode=three;
        head.leftNode=second;
        second.rightNode=five;
        second.leftNode=four;
        three.rightNode=seven;
        three.leftNode=six;
        System.out.print("深度优先遍历结果：");
        new DeepFirstSort().depthFirstSearch(head);
        System.out.print("广度优先遍历结果：");
        new DeepFirstSort().BroadFirstSearch(head);
    }

}
