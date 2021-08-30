package com.leetcode.offerTupo;

import com.leetcode.everyday.preDefine.Node;

/**
 * @Author yamon
 * @Date 2021-08-22 15:37
 * @Description 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * <p>
 * 给定位于列表第一级的头节点，请扁平化列表，即将这样的多级双向链表展平成普通的双向链表，使所有结点出现在单级双链表中。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * 解释：
 * <p>
 * 输入的多级列表如下图所示：
 * <p>
 * <p>
 * <p>
 * 扁平化后的链表如下图：
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2,null,3]
 * 输出：[1,3,2]
 * 解释：
 * <p>
 * 输入的多级列表如下图所示：
 * <p>
 * 1---2---NULL
 * |
 * 3---NULL
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 *  
 * <p>
 * 如何表示测试用例中的多级链表？
 * <p>
 * 以 示例 1 为例：
 * <p>
 * 1---2---3---4---5---6--NULL
 * |
 * 7---8---9---10--NULL
 * |
 * 11--12--NULL
 * 序列化其中的每一级之后：
 * <p>
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * 为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。
 * <p>
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * 合并所有序列化结果，并去除末尾的 null 。
 * <p>
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/Qv1Da2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class Flatten {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        //当链表没有节点，则直接更新节点即可。 比如这个示例：输入：head = [], insertVal = 1 输出：[1]
        if (head == null) {
            head = node;
            head.next = head;
        } else if (head.next == head) {
            //只存在一个节点时候，直接更新节点。比如head = 【1】 ，insertval=0 输出1，0
            head.next = node;
            node.next = head;
        } else {
            //去除特征条件，就只剩下以下两种情况
            insertCore(head, node);
        }
        return head;
    }

    void insertCore(Node head, Node node) {
        Node cur = head;
        Node next = head.next;
        Node biggest = head;
        //找到待插入的位置
        while (!(cur.val <= node.val && next.val >= node.val) && next != head) {
            cur = next;
            next = next.next;
            if (cur.val>=biggest.val){
                biggest = cur;
            }
        }
        //比较如果待插入的节点值位于原链表的范围内的话，则插入。比如
        //   1--（1）
        //   ^  |
        //   |  -
        //   4<-3(head)
        //   如果插入的是2的话，则插入的是（1）的位置
        //
        if (cur.val <= node.val && next.val>= node.val){
            cur.next = node;
            node.next = next;
        }else {

            //如果插入的是7的话，证明比最大的值都要大。插入的位置是最大的值后面也就是4后面。
            node.next = biggest.next;
            biggest.next = node;
        }
    }


}
