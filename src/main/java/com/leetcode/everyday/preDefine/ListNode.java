package com.leetcode.everyday.preDefine;

/**
 * @Author yamon
 * @Date 2021-03-25 8:41
 * @Description
 * @Version 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
