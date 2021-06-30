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
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        List<ListNode> listNodes = new ArrayList<>();
        if (head==null){
            return null;
        }
        while (head!=null){
            listNodes.add(head);
            head = head.next;
        }
        return listNodes.get(listNodes.size()-k);
    }
}
