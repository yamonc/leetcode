package com.leetcode.plan.easy21;

import com.leetcode.everyday.preDefine.ListNode;

/**
 * @Author yamon
 * @Date 2021-07-10 10:55
 * @Description
 * @Version 1.0
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //两次遍历
        if(head == null){
            return null;
        }
        ListNode cur = head;
        //记录节点数
        int length = 0;
        while(cur!=null){
            ++length;
            cur = cur.next;
        }
        // 寻找倒数第n个节点，然后删除
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre=dummy, temp = head;

        int num = length-n+1;
        if(length == 1 && num ==1){
            return null;
        }
        int count = 0;
        while(temp!=null){
            ++count;
            if(count==num){
                //删除节点
                temp =temp.next;
                pre.next = temp;
            }else{
                temp = temp.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
//        ListNode n2 = new ListNode(3);
//        ListNode n3 = new ListNode(4);
//        ListNode n4 = new ListNode(5);
        head.next=n1;
//        n1.next=n2;
//        n2.next=n3;
//        n3.next=n4;

        new RemoveNthFromEnd().removeNthFromEnd(head, 2);
    }
}
