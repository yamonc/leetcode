package com.leetcode.everyday.a202107;

import com.leetcode.everyday.preDefine.ListNode;

/**
 * @Author yamon
 * @Date 2021-03-27 8:43
 * @Description
 * @Version 1.0
 */
public class RotateRight {


    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        //整理成循环链表
        int n =1;
        //获取链表的长度
        ListNode iter = head;
        while (iter.next!=null){
            iter =iter.next;
            n++;
        }
        int add = n-k%n;
        if (add==n){
            return head;
        }
        iter.next=head;
        while(add-->0){
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next=null;
        return ret;
    }

    public static void main(String[] args) {
        final ListNode head1 = new ListNode();
        head1.val=1;
        ListNode node2 = new ListNode();
        node2.val=2;
        ListNode node3 = new ListNode();
        node3.val=3;
        ListNode node4 = new ListNode();
        node4.val=4;
        ListNode node5 = new ListNode();
        node5.val=5;

        head1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        new RotateRight().rotateRight(head1,3);
    }

}
