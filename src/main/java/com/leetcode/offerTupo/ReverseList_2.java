package com.leetcode.offerTupo;

import com.leetcode.everyday.preDefine.ListNode;

/**
 * @Author yamon
 * @Date 2021-08-20 15:18
 * @Description
 * @Version 1.0
 */
public class ReverseList_2 {
    public ListNode reverseList(ListNode head) {
        ListNode pre= head;
        ListNode cur = null;
        while (pre!=null){
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(4);
        ListNode h4 = new ListNode(5);
        head.next = h1;
        h1.next=h2;
        h2.next=h3;
        h3.next=h4;
        h4.next=null;
        new ReverseList_2().reverseList(head);
    }
}
