package com.leetcode.array;

import com.leetcode.everyday.preDefine.ListNode;

/**
 * @Author yamon
 * @Date 2021-04-14 21:05
 * @Description
 * @Version 1.0
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //添加哑节点
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i =1; i <length-n+1;++i){
            cur = cur.next;
        }
        cur.next=cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
    public int getLength(ListNode head){
        int length = 0;
        while (head!=null){
            length++;
            head=head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        new RemoveNthFromEnd().removeNthFromEnd(head,2);
    }
}
