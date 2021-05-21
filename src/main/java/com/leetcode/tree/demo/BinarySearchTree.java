package com.leetcode.tree.demo;

/**
 * @Author yamon
 * @Date 2021-05-19 20:19
 * @Description 二叉树的查找操作。
 * @Version 1.0
 */
public class BinarySearchTree {
    private Node tree;
    public Node find(int data){
        Node p = tree;
        while (p!=null){
            if (data<p.data){
                p=p.left;
            }else if(data>p.data){
                p=p.right;
            }else {
                return p;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node root = new Node(33);
        Node l = new Node(17);
        Node r = new Node(50);
        Node ll = new Node(13);
        Node lr = new Node(18);
        Node rl = new Node(34);
        Node rr = new Node(58);
        root.left=l;
        root.right=r;
        l.left=ll;
        l.right=lr;
        r.left=rl;
        r.right=rr;
        final BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.tree=root;
        final Node node = binarySearchTree.find(34);
        System.out.println(node.data);
        System.out.println(node);
    }
}
