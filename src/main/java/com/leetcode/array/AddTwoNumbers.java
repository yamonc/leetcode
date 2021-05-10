package com.leetcode.array;

import com.leetcode.everyday.preDefine.ListNode;

/**
 * @Author yamon
 * @Date 2021-04-11 10:07
 * @Description 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @Version 1.0
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode head = null,tail=null;
        while (l1!=null || l2!=null){
            int n1 = l1!=null ? l1.val:0;
            int n2 = l2!=null ? l2.val:0;
            int sum = n1+n2+carry;
            //创建新节点
            if (head==null){
                head = tail = new ListNode(sum%10);
            }else{
                tail.next = new ListNode(sum %10);
                tail = tail.next;
            }
            carry=sum/10;
            if (l1!=null){
                l1 = l1.next;
            }
            if (l2!=null){
                l2 = l2.next;
            }

        }
        if (carry>0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        final ListNode l10 = new ListNode();
        l10.val=2;
        ListNode l11 = new ListNode();
        l11.val=4;
        ListNode l12 = new ListNode();
        l12.val=3;

        ListNode l20 = new ListNode();
        l20.val=5;
        ListNode l21 = new ListNode();
        l21.val=6;
        ListNode l22 = new ListNode();
        l22.val=4;

        l10.next=l11;
        l11.next=l12;

        l20.next=l21;
        l21.next=l22;
        new AddTwoNumbers().addTwoNumbers(l10,l20);
    }
}
