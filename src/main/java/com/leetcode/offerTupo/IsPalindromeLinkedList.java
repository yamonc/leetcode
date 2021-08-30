package com.leetcode.offerTupo;

import com.leetcode.everyday.preDefine.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yamon
 * @Date 2021-08-22 15:24
 * @Description 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 *
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 * 示例 2：
 *
 *
 *
 * 输入: head = [1,2]
 * 输出: fasle
 *  
 *
 * 提示：
 *
 * 链表 L 的长度范围为 [1, 105]
 * 0 <= node.val <= 9
 *  
 *
 * 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/aMhZSa
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class IsPalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        //赋值到数组中
        List<Integer> list = new ArrayList<>();

        //链表的值赋值到数组中

        ListNode curr = head;
        while (curr!=null){
            list.add(curr.val);
            curr=curr.next;
        }
        //利用双指针判断是否回文
        int left = 0, right = list.size()-1;
        while (left<right){
            if (!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
