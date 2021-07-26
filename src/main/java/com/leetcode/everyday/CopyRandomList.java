package com.leetcode.everyday;

import com.leetcode.everyday.preDefine.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yamon
 * @Date 2021-07-22 10:23
 * @Description 复制带随机指针的链表
 * @Version 1.0
 */
public class CopyRandomList {
    public Node copyRandomList(Node head){
        //先不考虑random指针，复制一遍链表，然后创建新的节点，构建next指针，同时使用hash记录源节点和新节点的映射关系
        Map<Node,Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node tail = dummy, cur = head;
        while (cur!=null){
            //创建一个新的节点值
            Node node = new Node(cur.val);
            //将节点关系保存到map中，注意顺序。
            map.put(cur, node);
            //连接链表，给后排
            tail.next = node;
            tail = tail.next;
            //同时tmp给后移动
            cur = cur.next;
        }
        //复制结束之后，对原链表和新链表同时遍历，对原链表上的每个节点的random都通过hash表找到对应的新random值，并在新链表上构建新的random关系
        tail = dummy.next;
        while (head!=null){

            //当原来的节点的random不为空的时候，去map中找出来对应节点的random的值，然后赋给新链表的random
            if(head.random!=null){
                tail.random = map.get(head.random);
            }
            //两个指针都需要后移。
            tail=tail.next;
            head = head.next;
        }
        return dummy.next;
    }
}
