package com.newcode.offer;

import com.leetcode.everyday.preDefine.ListNode;

import java.util.ArrayList;

/**
 * @Author yamon
 * @Date 2021-08-10 15:41
 * @Description
 * @Version 1.0
 */
public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode cur = listNode, pre = null;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return null;
    }
}
