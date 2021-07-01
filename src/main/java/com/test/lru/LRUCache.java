package com.test.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache{
    class DLinkedNode{
        int key,value;
        DLinkedNode prev,next;
        public DLinkedNode(){};
        public DLinkedNode(int _key,int _value){
            key=_key;
            value=_value;
        }
    }
    private Map<Integer,DLinkedNode> cache=new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;
    public LRUCache(int capacity){
        this.size=size;
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }
    public int get(int key){
        DLinkedNode node=cache.get(key);
        if(node==null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    public void put(int key,int value){
        DLinkedNode node=cache.get(key);
        if(node==null){
            DLinkedNode newNode=new DLinkedNode(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            size++;
            if(size>capacity){
                DLinkedNode tail=removeTail();
                cache.remove(tail.key);
                --size;
            }
        }
        else{
            node.value=value;
            moveToHead(node);
        }
    }
    public void addToHead(DLinkedNode node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
    public void removeNode(DLinkedNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void moveToHead(DLinkedNode node){
        addToHead(node);
        removeNode(node);
    }
    public DLinkedNode removeTail(){
        DLinkedNode res=tail.prev;
        removeNode(res);
        return res;
    }
}

