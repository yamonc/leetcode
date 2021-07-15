package com.leetcode.offer;

import com.leetcode.everyday.preDefine.ListNode;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Stack;

/**
 * @Author yamon
 * @Date 2021-07-06 16:46
 * @Description 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * @Version 1.0
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        //使用栈
        Stack<Integer> stack = new Stack<>();
        if (head == null){
            return new int[0];
        }
        while (head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int[] ans = new int[stack.size()];
        for(int i = 0;i<ans.length;i++){
            if (!stack.isEmpty()){
                ans[i] = stack.pop();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(3);
        ListNode nextNext = new ListNode(2);
        head.next=next;
        next.next = nextNext;
        System.out.println(Arrays.toString(new ReversePrint().reversePrint(head)));
    }
}
