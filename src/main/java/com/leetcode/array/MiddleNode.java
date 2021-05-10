package com.leetcode.array;

import com.leetcode.everyday.preDefine.ListNode;

/**
 * @Author yamon
 * @Date 2021-04-15 20:10
 * @Description
 * @Version 1.0
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        int length = getLength(head);
        int _length = length / 2 + 1;
        for (int i = 1; i < _length; i++) {
            head = head.next;
        }
        return head;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        new MiddleNode().middleNode(head);
    }
}
