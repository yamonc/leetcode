package com.leetcode.offerTupo;

import com.leetcode.everyday.preDefine.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-08-20 16:04
 * @Description 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 *  L0 → L1 → … → Ln-1 → Ln 
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 *
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入: head = [1,2,3,4]
 * 输出: [1,4,2,3]
 * 示例 2:
 *
 *
 *
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,5,2,4,3]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/LGjMqU
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        //重建链表
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node !=null){
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size()-1;
        while (i<j){
            list.get(i).next = list.get(j);
            i++;
            if (i==j){
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}
