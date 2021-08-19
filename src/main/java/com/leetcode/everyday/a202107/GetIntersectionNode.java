package com.leetcode.everyday.a202107;

import com.leetcode.everyday.preDefine.ListNode;

/**
 * @Author yamon
 * @Date 2021-06-04 15:49
 * @Description 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 *
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        ListNode ans = null;
        while (a.next!=null && b.next!=null){
            if (a.val!=b.val){
                a = a.next;
                b = b.next;
            }else{
                ans = new ListNode(a.val);
                ans = a.next;
            }
        }
        return ans;
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
        new GetIntersectionNode().getIntersectionNode(headA,headB);
    }
}
