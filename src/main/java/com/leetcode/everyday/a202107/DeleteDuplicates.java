package com.leetcode.everyday.a202107;

import com.leetcode.everyday.preDefine.ListNode;

/**
 * @Author yamon
 * @Date 2021-03-25 8:41
 * @Description 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * @Version 1.0 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {

        if (head==null){
            return head;
        }
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        while (cur.next!=null && cur.next.next!=null){
            if (cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while(cur.next!=null && cur.next.val==x){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        final ListNode head1 = new ListNode();
        head1.val=1;
        ListNode node2 = new ListNode();
        node2.val=2;
        ListNode node3 = new ListNode();
        node3.val=3;
        ListNode node4 = new ListNode();
        node4.val=3;
        ListNode node5 = new ListNode();
        node5.val=4;
        ListNode node6 = new ListNode();
        node6.val=4;
        ListNode node7 = new ListNode();
        node7.val=5;

        head1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        new DeleteDuplicates().deleteDuplicates(head1);
    }

}
