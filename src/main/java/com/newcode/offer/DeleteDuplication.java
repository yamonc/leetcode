package com.newcode.offer;

import com.leetcode.everyday.preDefine.ListNode;

import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author yamon
 * @Date 2021-06-23 16:52
 * @Description 描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @Version 1.0
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        //特判
        if (pHead==null) {
            return null;
        }
        ListNode pre = pHead;
        ListNode cur = pHead.next;
        //记录重复的节点值
        Set<Integer> set = new HashSet<>();
        //遍历链表
        while (cur!=null){
            if (pre.val == cur.val) {
                set.add(pre.val);
            }
            pre = pre.next;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        pre = dummy;
        cur = pHead;
        while (cur!=null){
            if (set.contains(cur.val)){
                cur = cur.next;
                pre.next = cur;
            }else{
                cur = cur.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(3);
        ListNode next4 = new ListNode(4);
        ListNode next5 = new ListNode(4);
        ListNode next6 = new ListNode(5);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = next5;
        next5.next = next6;
        new DeleteDuplication().deleteDuplication(head);
    }
}
