package com.leetcode.tree.demo;

/**
 * @Author yamon
 * @Date 2021-05-19 20:30
 * @Description 二叉查找树的插入操作
 * @Version 1.0
 */
public class BinarySearchTreeInsert {
    public Node tree;
    public void insert(int data){
        if (tree == null){
            tree = new Node(data);
            return;
        }
        Node p = tree;
        Node temp = new Node(data);
        while (p!=null){
            if (data>p.data){
                if (p.right!=null){
                    p=p.right;
                }else{
                    p.right=temp;
                    return;
                }
            }else{
                if (p.left!=null){
                    p=p.left;
                }else{
                    p.left=temp;
                    return;
                }
            }
        }
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
        final BinarySearchTreeInsert binarySearchTreeInsert = new BinarySearchTreeInsert();
        binarySearchTreeInsert.tree=root;
        binarySearchTreeInsert.insert(51);
    }
}
