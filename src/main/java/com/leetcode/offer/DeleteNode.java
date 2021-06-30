package com.leetcode.offer;

import com.leetcode.everyday.preDefine.ListNode;

/**
 * @Author yamon
 * @Date 2021-06-23 16:40
 * @Description 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0 单个指针，先确定了相等的位置，然后向后移动一个位置即可。
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        while (cur.next!=null && cur.next.val != val){
            cur = cur.next;
        }
        //找到了相等的节点，删除即可。
        if (cur.next!=null){
            cur.next = cur.next.next;
        }
        return head;
    }
}
