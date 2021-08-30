package com.leetcode.offerTupo.preDefine;

/**
 * @Author yamon
 * @Date 2021-08-22 16:07
 * @Description
 * @Version 1.0
 */
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}
