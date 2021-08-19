package com.test;

import com.leetcode.everyday.preDefine.ListNode;

import java.util.*;

/**
 * @Author yamon
 * @Date 2021-07-28 20:23
 * @Description
 * @Version 1.0
 */
public class Test2 {
    static ListNode node = null;
    static int n,k;
    public static ListNode removeKthNode(ListNode head, int k){
        int count = 0;
        ListNode cur = node;
        ListNode dummy = new ListNode(-1);
        dummy.next = node;
        while (cur!=null) {
            count++;
            if(k==count){
                //当k等于count的时候删除节点
                dummy.next = cur.next;
                return dummy.next;
            }
            cur=cur.next;
            dummy = dummy.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        List<ListNode> list = new ArrayList<>();
        while (sc.hasNextInt()) {
            // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            list.add(new ListNode(sc.nextInt()));
            if(sc.nextInt()==-1){
                break;
            }
        }
//        ListNode head = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4= new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        head.next = n2;
//        n2.next=n3;
//        n3.next=n4;
//        n4.next=n5;
//        int k = 3;
        //开始算法


    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
