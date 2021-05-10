package com.leetcode.stack.practice;

import java.util.Iterator;

/**
 * @Author yamon
 * @Date 2021-05-03 10:26
 * @Description
 * @Version 1.0
 */
public class StackOfArray<Item> implements Iterable<Item> {
    //存储数据的数组
    Item[] a = (Item[]) new Object[1];
    int N =0;
    public StackOfArray(){

    }
    public void push(Item item){
        //自动扩容
        if (N==a.length){
            resize(2*a.length);
        }
        a[N++]=item;
    }
    public Item pop(){
        Item item = a[--N];
        a[N]=null;
        if (N>0 && N==a.length/4){
            resize(a.length/2);
        }
        return item;
    }

    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void resize(int length){
        Item[] temp = (Item[]) new Object[length];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a=temp;
    }
    public Item peek(){
        return a[N-1];
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }
    class ArrayIterator implements Iterator{
        int i = N;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return i>0;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws  if the iteration has no more elements
         */
        @Override
        public Item next() {
            return a[--i];
        }
    }
}
