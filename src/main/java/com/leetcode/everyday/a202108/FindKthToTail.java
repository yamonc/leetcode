package com.leetcode.everyday.a202108;

import com.leetcode.everyday.preDefine.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author yamon
 * @Date 2021-08-10 16:44
 * @Description
 * @Version 1.0
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        if (pHead == null) {
            return pHead;
        }
        ListNode first = pHead;
        ListNode second = pHead;
        //第一个指针先走k步
        while (k-- > 0) {
            if (first==null){
                return null;
            }
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second =second.next;
        }
        return second;
    }
}
