package com.leetcode.offerTupo;

import org.w3c.dom.Node;

import java.util.HashMap;

/**
 * @Author yamon
 * @Date 2021-08-24 15:13
 * @Description
 * @Version 1.0
 */
public class LRUCache {
    class Node{
        public int key, val;
        public Node next, prev;
        public Node(int k, int v){
            this.key = k;
            this.val = v;
        }
    }
    class DoubleList{
        private Node head, tail;
        private int size;
        //在链表头部添加节点x
        public void addFirst(Node node){
            if (head == null){
                head = tail = node;
            }else{
                //前插法：首先将头节点定义一个新引用n，和head一样同时指向head节点
                Node n = head;
                //将node节点赋值给n也就是head节点的前驱节点
                n.prev = node;
                //将node的next指针指向n，也就是head节点。
                node.next = n;
                //head前移。
                head = node;
            }
            size++;
        }
        //删除链表中的x节点
        public void remove(Node node){
            if (head == node && tail == node){
                //如果head就是待删除的节点并且tail也是node节点，换句话说就是只有一个node节点的时候
                head = null;
                tail = null;
            }else if (tail == node){
                //如果尾节点是待删除节点node的话
                //将node节点的前驱节点的next指针设置为null，然后tail指针指向node的前驱节点
                node.prev.next = null;
                tail = node.prev;
            }else if (head == node){
                //如果删除的节点是头节点的话
                //将node节点的后继节点的prev设置为null，然后设置head节点为node的next
                node.next.prev = null;
                head = node.next;
            }else{
                //删除的节点在中间
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }
        //删除链表中的最后一个节点，并返回该节点。
        public Node removeLast(){
            //重新创建一个node节点，然后将node节点删除
            Node node = tail;
            remove(tail);
            return node;
        }
        //返回链表长度。
        public int size(){
            return this.size;
        }
    }
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        //先new出来一个新节点x
        Node x = new Node(key, value);
        if (map.containsKey(key)){
            //先删除旧节点
            cache.remove(map.get(key));
            //新节点的插入到头部
            cache.addFirst(x);
            //同时更新map，
            map.put(key, x);
        }else {
            if (cap == cache.size){
                //删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            //直接添加到头部
            cache.addFirst(x);
            map.put(key,x);
        }
    }
}
