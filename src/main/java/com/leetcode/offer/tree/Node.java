package com.leetcode.offer.tree;

/**
 * @Author yamon
 * @Date 2021-07-09 21:16
 * @Description
 * @Version 1.0
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
