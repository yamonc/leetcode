package com.leetcode.array;

import com.leetcode.everyday.preDefine.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author yamon
 * @Date 2021-04-16 21:07
 * @Description 编写一个程序，找到两个单链表相交的起始节点 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class GetIntersectionNode2 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB== null){
            return null;
        }
        ListNode head1 = headA;
        ListNode head2 = headB;
        while (head1!=head2){
            if (head1!=null){
                head1=head1.next;
            }else{
                head1 = headB;
            }

            if (head2!=null){
                head2 = head2.next;
            }else {
                head2 = headA;
            }
        }
        return head1;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(5);
        ListNode nodeA2 = new ListNode(0);
        ListNode nodeA3 = new ListNode(1);
        ListNode nodeA4 = new ListNode(8);
        ListNode nodeA5 = new ListNode(4);
        ListNode nodeA6 = new ListNode(5);
        headA.next=nodeA2;
        nodeA2.next=nodeA3;
        nodeA3.next=nodeA4;
        nodeA4.next=nodeA5;
        nodeA5.next=nodeA6;
        ListNode headB = new ListNode(4);
        ListNode nodeB2 = new ListNode(1);
        ListNode nodeB3 = new ListNode(8);
        ListNode nodeB4 = new ListNode(4);
        ListNode nodeB5 = new ListNode(5);
        headB.next=nodeB2;
        nodeB2.next=nodeB3;
        nodeB3.next=nodeB4;
        nodeB4.next=nodeB5;
        new GetIntersectionNode2().getIntersectionNode(headA,headB);
    }
}
