package com.leetcode.stack.practice;

import java.util.Iterator;

/**
 * @Author yamon
 * @Date 2021-05-03 10:35
 * @Description 栈的链表实现
 * @Version 1.0
 */
public class StackOfLinked<Item> implements Iterable<Item>{
    //定义一个内部类
    private class Node{
        Item item;
        Node next;
    }
    private Node first;
    private int N;

    public StackOfLinked() {
    }

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item=item;
        first.next= oldFirst;
        N++;
    }
    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public Item peek(){
        return first.item;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }
    //内部类：迭代器
    class LinkedIterator implements Iterator{
        int i = N;
        Node t = first;
        @Override
        public boolean hasNext() {
            return i > 0;
        }
        @Override
        public Item next() {
            Item item = (Item) t.item;
            t = t.next;
            i--;
            return item;
        }
    }
}
