package com.leetcode.array;

import com.leetcode.everyday.preDefine.ListNode;

import java.util.Stack;

/**
 * @Author yamon
 * @Date 2021-04-12 20:23
 * @Description
 * @Version 1.0
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode prev = head;
        while (prev!=null){
            ListNode temp = prev.next;
            prev.next=cur;
            cur = prev;
            prev=temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        final ListNode head = new ListNode();
        head.val=1;
        ListNode node2 = new ListNode();

        node2.val=2;
        head.next=node2;
        ListNode node3 = new ListNode();
        node3.val=3;
        node2.next=node3;
        ListNode node4 = new ListNode();
        node4.val=4;
        node3.next=node4;
        ListNode node5 = new ListNode();
        node5.val=5;
        node4.next=node5;
        new ReverseList().reverseList(head);
    }
}
