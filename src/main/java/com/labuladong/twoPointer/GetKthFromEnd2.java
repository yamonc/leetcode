package com.labuladong.twoPointer;

import com.leetcode.everyday.preDefine.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-06-17 10:43
 * @Description
 * @Version 1.0
 */
public class GetKthFromEnd2 {
    public ListNode getKthFromEnd(ListNode head, int k) {
       ListNode fast,slow;
       fast=slow=head;
       //fast先走k步
        while (k-- >0){
            fast = fast.next;
        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
