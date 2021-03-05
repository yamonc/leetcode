package com.leetcode.tree;

import java.util.*;

/**
 * @Author yamon
 * @Date 2021-03-01 10:55
 * @Description
 * @Version 1.0
 */
public class MaxDepthNoneEr {
    public int maxDepth(Node root){
        if (root==null){
            return 0;
        }else if(root.children.isEmpty()){
            return 1;
        }else {
            List<Integer> heights= new LinkedList<>();
            for (Node item:root.children){
                heights.add(maxDepth(item));
            }
            return Collections.max(heights)+1;
        }
    }

    public static void main(String[] args) {



        Node leftleft=new Node(5,new LinkedList<>());
        Node leftright=new Node(6,new LinkedList<>());
        List<Node> leftChildren=new LinkedList<>();
        leftChildren.add(leftleft);
        leftChildren.add(leftright);
        Node left=new Node(3,leftChildren);
        Node middle = new Node(2,new LinkedList<>());
        Node right=new Node(4,new LinkedList<>());
        List<Node> rootChildren=new LinkedList<>();
        rootChildren.add(left);
        rootChildren.add(middle);
        rootChildren.add(right);
        Node root=new Node(1, rootChildren);
        final int i = new MaxDepthNoneEr().maxDepth(root);
        System.out.println(i);
    }

}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}


